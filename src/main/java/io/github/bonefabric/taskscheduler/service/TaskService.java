package io.github.bonefabric.taskscheduler.service;

import io.github.bonefabric.taskscheduler.model.Task;
import io.github.bonefabric.taskscheduler.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;

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

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    public Optional<Task> update(long id, Consumer<Task> modifier) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isPresent()) {
            Task result = task.get();
            modifier.accept(result);
            result.setId(id);
            return Optional.of(taskRepository.save(result));
        }
        return task;
    }

    @Transactional
    public boolean delete(long id) {
        if (!taskRepository.existsById(id)) {
            return false;
        }
        taskRepository.deleteById(id);
        return true;
    }
}
