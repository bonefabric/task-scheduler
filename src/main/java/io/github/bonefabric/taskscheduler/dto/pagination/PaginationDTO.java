package io.github.bonefabric.taskscheduler.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PaginationDTO<T> {

    private int page;
    private int pageSize;
    private long total;
    private List<T> data;
}
