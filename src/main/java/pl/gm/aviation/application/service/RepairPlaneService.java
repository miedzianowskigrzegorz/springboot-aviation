package pl.gm.aviation.application.service;

import common.UseCase;
import lombok.RequiredArgsConstructor;
import pl.gm.aviation.application.port.in.RepairPlaneCommand;
import pl.gm.aviation.application.port.in.RepairPlaneUseCase;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class RepairPlaneService implements RepairPlaneUseCase {

    @Override
    public boolean repairPlane(RepairPlaneCommand repairPlaneCommand) {
        return false;
    }

}
