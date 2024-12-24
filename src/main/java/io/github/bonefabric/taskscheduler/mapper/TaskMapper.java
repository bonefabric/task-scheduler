package io.github.bonefabric.taskscheduler.mapper;

import io.github.bonefabric.taskscheduler.dto.task.CreateTaskDTO;
import io.github.bonefabric.taskscheduler.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task map(CreateTaskDTO createTaskDTO) {
        Task task = new Task();
        task.setName(createTaskDTO.getName());
        task.setDescription(createTaskDTO.getDescription());
        return task;
    }
}
