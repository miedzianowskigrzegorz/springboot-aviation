package pl.gm.aviation.application.port.in;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
public class MovePlaneCommand {

    @NotNull
    private final Long moveFrom;

    @NotNull
    private final Long moveTo;

    @NotNull
    private final Long planeId;

}
