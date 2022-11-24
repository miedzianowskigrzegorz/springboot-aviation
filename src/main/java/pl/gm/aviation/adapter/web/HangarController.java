package pl.gm.aviation.adapter.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gm.aviation.application.port.in.MovePlaneCommand;
import pl.gm.aviation.application.port.in.RepairPlaneUseCase;

@Controller
@RequestMapping("/hangar")
@RequiredArgsConstructor
public class HangarController {

    private final RepairPlaneUseCase repairPlane;

    @GetMapping("/send-for-repair/{hangar.id}/{workshop.id}/{plane.id}")
    String repairPlane(@PathVariable("hangar.id") Long hangarId,
                       @PathVariable("workshop.id") Long workshopId,
                       @PathVariable("plane.id") Long planeId,
                       Model model) {

        MovePlaneCommand movePlaneCommand = new MovePlaneCommand(hangarId, workshopId, planeId);
        repairPlane.repairPlane(movePlaneCommand);

        return "redirect:/";

    }

}
