package io.github.bonefabric.taskscheduler.dto.pagination;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class PaginationRequestDTO {

    public static final int DEFAULT_PAGE_SIZE = 20;

    @Min(0)
    private int page;

    @Min(1)
    @Max(9999)
    private int pageSize;

    public PaginationRequestDTO(Integer page, Integer pageSize) {
        this.page = Optional.ofNullable(page).orElse(1);
        this.pageSize = Optional.ofNullable(pageSize).orElse(DEFAULT_PAGE_SIZE);
    }
}
