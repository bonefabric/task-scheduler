package io.github.bonefabric.taskscheduler.dto.task;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchTaskDTO {

    @Size(max = 255)
    private String name;

    @Size(max = 1024)
    private String description;
}
