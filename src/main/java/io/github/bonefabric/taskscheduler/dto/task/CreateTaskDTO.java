package io.github.bonefabric.taskscheduler.dto.task;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTaskDTO {

    @NotEmpty
    @Size(min = 1, max = 255)
    private String name;

    @Size(max = 1024)
    private String description;
}
