package io.github.bonefabric.taskscheduler.controller.api.v1;

import io.github.bonefabric.taskscheduler.dto.pagination.PaginationDTO;
import io.github.bonefabric.taskscheduler.dto.pagination.PaginationRequestDTO;
import io.github.bonefabric.taskscheduler.mapper.PaginationMapper;
import io.github.bonefabric.taskscheduler.model.Task;
import io.github.bonefabric.taskscheduler.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
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

    @GetMapping
    public PaginationDTO<Task> list(@Valid PaginationRequestDTO requestDTO) {
        Page<Task> resultPage = taskService.page(requestDTO.getPage(), requestDTO.getPageSize());
        return paginationMapper.map(resultPage);
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable @DecimalMin("1") long id) {
        return taskService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
