package io.github.bonefabric.taskscheduler.service;

import io.github.bonefabric.taskscheduler.model.Task;
import io.github.bonefabric.taskscheduler.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Page<Task> page(int page, int pageSize) {
        return taskRepository.findAll(PageRequest.of(page, pageSize));
    }

    public Optional<Task> findById(long id) {
        return taskRepository.findById(id);
    }
}
