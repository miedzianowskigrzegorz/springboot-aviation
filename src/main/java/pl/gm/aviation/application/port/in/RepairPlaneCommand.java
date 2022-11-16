package pl.gm.aviation.application.port.in;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
public class RepairPlaneCommand {

    @NotNull
    private final Long hangarId;

    @NotNull
    private final Long workshopId;

    @NotNull
    private final Long planeId;

}
