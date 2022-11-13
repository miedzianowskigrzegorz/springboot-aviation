package pl.gm.aviation.adapter.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gm.aviation.adapter.persistence.inmemory.InMemoryAirportAdapter;
import pl.gm.aviation.application.port.in.RepairPlaneUseCase;
import pl.gm.aviation.domain.plane.Plane;

@Controller
@RequestMapping("/repair")
@RequiredArgsConstructor
public class RepairPlaneController {

    private final RepairPlaneUseCase repairPlane;
    private final InMemoryAirportAdapter inMemoryAirportAdapter;


    @GetMapping("/{hangar.id}/{plane.id}")
    String repairPlane(@PathVariable("hangar.id") Long hangarId,
                     @PathVariable("plane.id") Long planeId,
                       Model model) {

        Plane plane = inMemoryAirportAdapter.loadPlane(planeId);
        if(!plane.mayBeServiced()) {
            return "redirect:/";
        }
        return inMemoryAirportAdapter.loadHangar(hangarId).toString() + "  " + inMemoryAirportAdapter.loadPlane(planeId);

    }

}
