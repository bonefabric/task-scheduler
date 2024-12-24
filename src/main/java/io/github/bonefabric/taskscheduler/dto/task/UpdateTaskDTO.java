package io.github.bonefabric.taskscheduler.dto.task;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateTaskDTO {

    @NotEmpty
    @Size(min = 1, max = 255)
    private final String name;

    @Size(max = 1024)
    private final String description;

    public UpdateTaskDTO(String name, String description) {
        this.name = name;
        this.description = description == null ? "" : description;
    }
}
