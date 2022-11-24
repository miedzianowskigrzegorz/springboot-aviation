package pl.gm.aviation.adapter.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gm.aviation.adapter.persistence.inmemory.InMemoryAirportAdapter;
import pl.gm.aviation.application.port.in.FixPlaneCommand;
import pl.gm.aviation.application.port.in.FixPlaneUseCase;
import pl.gm.aviation.application.port.in.MovePlaneCommand;
import pl.gm.aviation.application.port.in.ReturnToHangarUseCase;
import pl.gm.aviation.domain.airportzones.airside.Hangar;

import java.util.List;

@Controller
@RequestMapping("/workshop")
@RequiredArgsConstructor
public class WorkshopController {

    private final FixPlaneUseCase fixPlaneUseCase;
    private final ReturnToHangarUseCase returnToHangarUseCase;
    private final InMemoryAirportAdapter inMemoryAirportAdapter;

    @ModelAttribute("hangars")
    public List<Hangar> getAirsideHangars() {

        return inMemoryAirportAdapter.loadHangars(1L);

    }


    @GetMapping("/fix/{plane.id}")
    String fixPlane(@PathVariable("plane.id") Long planeId) {

        FixPlaneCommand fixPlaneCommand = new FixPlaneCommand(planeId);
        fixPlaneUseCase.fixPlane(fixPlaneCommand);
        return "redirect:/";

    }

    @GetMapping("/send/{workshop.id}/{plane.id}")
    String sendPlaneToHangar(@PathVariable("workshop.id") Long workshopId, @PathVariable("plane.id") Long planeId, Model model) {

        model.addAttribute("moveComand", new MovePlaneCommand(workshopId, 0L, planeId));
        return "workshop/send-plane";

    }

    @PostMapping("/send/plane")
    public String sendPlane(MovePlaneCommand movePlaneCommand) {

        returnToHangarUseCase.returnToHangar(movePlaneCommand);
        return "redirect:/";

    }

}
