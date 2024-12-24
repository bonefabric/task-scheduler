package io.github.bonefabric.taskscheduler.mapper;

import io.github.bonefabric.taskscheduler.dto.task.CreateTaskDTO;
import io.github.bonefabric.taskscheduler.dto.task.PatchTaskDTO;
import io.github.bonefabric.taskscheduler.dto.task.UpdateTaskDTO;
import io.github.bonefabric.taskscheduler.model.Task;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class TaskMapper {

    public Task map(CreateTaskDTO createTaskDTO) {
        Task task = new Task();
        task.setName(createTaskDTO.getName());
        task.setDescription(createTaskDTO.getDescription());
        return task;
    }

    public Consumer<Task> updater(UpdateTaskDTO updateTaskDTO) {
        return task -> {
            task.setName(updateTaskDTO.getName());
            task.setDescription(updateTaskDTO.getDescription());
        };
    }

    public Consumer<Task> patcher(PatchTaskDTO patchTaskDTO) {
        return task -> {
            if (patchTaskDTO.getName() != null) {
                task.setName(patchTaskDTO.getName());
            }

            if (patchTaskDTO.getDescription() != null) {
                task.setDescription(patchTaskDTO.getDescription());
            }
        };
    }
}
