package pl.gm.aviation.application.service;

import common.UseCase;
import lombok.RequiredArgsConstructor;
import pl.gm.aviation.application.port.in.*;
import pl.gm.aviation.application.port.out.*;
import pl.gm.aviation.domain.airportzones.airside.Hangar;
import pl.gm.aviation.domain.airportzones.airside.Workshop;
import pl.gm.aviation.domain.plane.Plane;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class RepairPlaneService implements RepairPlaneUseCase, ReturnToHangarUseCase, FixPlaneUseCase {

    private final LoadAirsideHangarsPort loadAirsideHangarsPort;
    private final LoadAirsideWorkshopPort loadAirsideWorkshopPort;
    private final LoadPlanePort loadPlanePort;
    private final UpdateWorkshopStatePort updateWorkshopStatePort;
    private final UpdateHangarStatePort updateHangarStatePort;

    @Override
    public boolean repairPlane(MovePlaneCommand repairPlaneCommand) {

        Hangar hangar = loadAirsideHangarsPort.loadHangar(repairPlaneCommand.getMoveFrom());
        Workshop workshop = loadAirsideWorkshopPort.loadWorkshop(repairPlaneCommand.getMoveTo());
        Plane plane = loadPlanePort.loadPlaneFromHangar(repairPlaneCommand.getPlaneId());

        if(!plane.mayBeServiced()) {
            return false;
        }

        hangar.removePlane(plane);
        workshop.addPlane(plane);

        updateWorkshopStatePort.updateWorkshopState(workshop);
        updateHangarStatePort.updateHangarState(hangar);
        return true;

    }

    @Override
    public boolean returnToHangar(MovePlaneCommand movePlaneCommand) {

        Workshop workshop = loadAirsideWorkshopPort.loadWorkshop(movePlaneCommand.getMoveFrom());
        Hangar hangar = loadAirsideHangarsPort.loadHangar(movePlaneCommand.getMoveTo());
        Plane plane = loadPlanePort.loadPlaneFromWorkshop(movePlaneCommand.getPlaneId());

        if(plane.mayBeServiced()) {
            return false;
        }

        workshop.removePlane(plane);
        hangar.addPlane(plane);

        updateWorkshopStatePort.updateWorkshopState(workshop);
        updateHangarStatePort.updateHangarState(hangar);
        return true;

    }

    @Override
    public boolean fixPlane(FixPlaneCommand fixPlaneCommand) {

        Plane plane = loadPlanePort.loadPlaneFromWorkshop(fixPlaneCommand.getPlaneId());
        if(!plane.mayBeServiced()) {
            return false;
        }
        plane.setPlaneSubmittedForRepair(false);
        return true;

    }
}
