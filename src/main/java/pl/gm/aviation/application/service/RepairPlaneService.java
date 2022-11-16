package pl.gm.aviation.application.service;

import common.UseCase;
import lombok.RequiredArgsConstructor;
import pl.gm.aviation.application.port.in.RepairPlaneCommand;
import pl.gm.aviation.application.port.in.RepairPlaneUseCase;
import pl.gm.aviation.application.port.out.*;
import pl.gm.aviation.domain.airportzones.airside.Hangar;
import pl.gm.aviation.domain.airportzones.airside.Workshop;
import pl.gm.aviation.domain.plane.Plane;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class RepairPlaneService implements RepairPlaneUseCase {

    private final LoadAirsideHangarsPort loadAirsideHangarsPort;
    private final LoadAirsideWorkshopPort loadAirsideWorkshopPort;
    private final LoadPlanePort loadPlanePort;
    private final UpdateWorkshopStatePort updateWorkshopStatePort;
    private final UpdateHangarStatePort updateHangarStatePort;

    @Override
    public boolean repairPlane(RepairPlaneCommand repairPlaneCommand) {

        Hangar hangar = loadAirsideHangarsPort.loadHangar(repairPlaneCommand.getHangarId());
        Workshop workshop = loadAirsideWorkshopPort.loadWorkshop(repairPlaneCommand.getWorkshopId());
        Plane plane = loadPlanePort.loadPlane(repairPlaneCommand.getPlaneId());

        if(!plane.mayBeServiced()) {
            return false;
        }

        hangar.removePlane(plane);
        workshop.addPlane(plane);

        updateWorkshopStatePort.updateWorkshopState(workshop);
        updateHangarStatePort.updateHangarState(hangar);
        return true;

    }

}
