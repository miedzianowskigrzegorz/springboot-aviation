package pl.gm.aviation.adapter.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gm.aviation.adapter.persistence.inmemory.InMemoryAirportAdapter;
import pl.gm.aviation.application.port.in.RepairPlaneUseCase;

@Controller
@RequestMapping("/repair")
@RequiredArgsConstructor
public class RepairPlaneController {

    private final RepairPlaneUseCase repairPlane;
    private final InMemoryAirportAdapter inMemoryAirportAdapter;


    @GetMapping("/{hangar.id}/{plane.id}")
    @ResponseBody
    String repairPlane(@PathVariable("hangar.id") Long hangarId,
                     @PathVariable("plane.id") Long planeId) {

        return inMemoryAirportAdapter.loadHangar(hangarId).toString();

    }

}
