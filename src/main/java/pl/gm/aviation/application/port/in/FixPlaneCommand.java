package pl.gm.aviation.application.port.in;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
public class FixPlaneCommand {

    @NotNull
    private final Long planeId;

}
