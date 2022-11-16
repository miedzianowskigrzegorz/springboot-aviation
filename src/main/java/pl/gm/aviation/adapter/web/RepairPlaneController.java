package pl.gm.aviation.adapter.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gm.aviation.adapter.persistence.inmemory.InMemoryAirportAdapter;
import pl.gm.aviation.application.port.in.RepairPlaneCommand;
import pl.gm.aviation.application.port.in.RepairPlaneUseCase;
import pl.gm.aviation.domain.plane.Plane;

@Controller
@RequestMapping("/repair")
@RequiredArgsConstructor
public class RepairPlaneController {

    private final RepairPlaneUseCase repairPlane;

    @GetMapping("/{hangar.id}/{workshop.id}/{plane.id}")
    String repairPlane(@PathVariable("hangar.id") Long hangarId,
                     @PathVariable("workshop.id") Long workshopId,
                     @PathVariable("plane.id") Long planeId,
                       Model model) {

        RepairPlaneCommand repairPlaneCommand = new RepairPlaneCommand(hangarId,workshopId,planeId);
        repairPlane.repairPlane(repairPlaneCommand);



        return "redirect:/";

    }

}
