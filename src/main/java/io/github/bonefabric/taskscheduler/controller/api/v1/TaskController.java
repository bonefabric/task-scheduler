package io.github.bonefabric.taskscheduler.controller.api.v1;

import io.github.bonefabric.taskscheduler.dto.pagination.PaginationDTO;
import io.github.bonefabric.taskscheduler.dto.pagination.PaginationRequestDTO;
import io.github.bonefabric.taskscheduler.dto.task.CreateTaskDTO;
import io.github.bonefabric.taskscheduler.dto.task.PatchTaskDTO;
import io.github.bonefabric.taskscheduler.dto.task.UpdateTaskDTO;
import io.github.bonefabric.taskscheduler.mapper.PaginationMapper;
import io.github.bonefabric.taskscheduler.mapper.TaskMapper;
import io.github.bonefabric.taskscheduler.model.Task;
import io.github.bonefabric.taskscheduler.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "api/v1/task", consumes = "application/json", produces = "application/json")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final PaginationMapper<Task> paginationMapper;
    private final TaskMapper taskMapper;

    @GetMapping
    public PaginationDTO<Task> list(@Valid PaginationRequestDTO requestDTO) {
        Page<Task> resultPage = taskService.page(requestDTO.getPage(), requestDTO.getPageSize());
        return paginationMapper.map(resultPage);
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable @Min(1) long id) {
        return taskService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody @Valid CreateTaskDTO createTaskDTO) {
        return taskService.save(taskMapper.map(createTaskDTO));
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable @Min(1) long id, @RequestBody @Valid UpdateTaskDTO updateTaskDTO) {
        return taskService.update(id, taskMapper.updater(updateTaskDTO))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}")
    public Task patch(@PathVariable @Min(1) long id, @RequestBody @Valid PatchTaskDTO patchTaskDTO) {
        return taskService.update(id, taskMapper.patcher(patchTaskDTO))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(1) long id) {
        if (!taskService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
