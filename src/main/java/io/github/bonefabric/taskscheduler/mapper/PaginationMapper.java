package io.github.bonefabric.taskscheduler.mapper;

import io.github.bonefabric.taskscheduler.dto.pagination.PaginationDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PaginationMapper<T> {

    public PaginationDTO<T> map(Page<T> page) {
        return new PaginationDTO<>(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getContent()
        );
    }
}
