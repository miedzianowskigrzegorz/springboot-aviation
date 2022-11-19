package pl.gm.aviation.adapter.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gm.aviation.application.port.in.FixPlaneCommand;
import pl.gm.aviation.application.port.in.FixPlaneUseCase;

@Controller
@RequestMapping("/workshop")
@RequiredArgsConstructor
public class WorkshopController {

    private final FixPlaneUseCase fixPlaneUseCase;

    @GetMapping("/fix/{plane.id}")
    String fixPlane(@PathVariable("plane.id") Long planeId) {

        FixPlaneCommand fixPlaneCommand = new FixPlaneCommand(planeId);
        fixPlaneUseCase.fixPlane(fixPlaneCommand);

        return "redirect:/";

    }

}
