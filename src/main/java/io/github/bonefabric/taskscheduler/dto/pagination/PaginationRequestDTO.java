package io.github.bonefabric.taskscheduler.dto.pagination;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class PaginationRequestDTO {

    public static final int DEFAULT_PAGE_SIZE = 20;

    @DecimalMin("1")
    @DecimalMax("999999")
    private int page;

    @DecimalMin("1")
    @DecimalMax("999999")
    private int pageSize;

    public PaginationRequestDTO(Integer page, Integer pageSize) {
        this.page = Optional.ofNullable(page).orElse(1);
        this.pageSize = Optional.ofNullable(pageSize).orElse(DEFAULT_PAGE_SIZE);
    }
}
