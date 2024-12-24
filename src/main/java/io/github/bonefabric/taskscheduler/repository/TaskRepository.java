package io.github.bonefabric.taskscheduler.repository;

import io.github.bonefabric.taskscheduler.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long>, CrudRepository<Task, Long> {
}
