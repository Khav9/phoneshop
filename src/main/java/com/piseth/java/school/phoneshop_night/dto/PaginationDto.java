package com.piseth.java.school.phoneshop_night.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationDto {
    private int pageSize;
    private int pageNumber;
    private int totalPages;
    private long totalElement;
    private long numberOfElements;

    private boolean first;
    private boolean last;
    private boolean empty;
}
