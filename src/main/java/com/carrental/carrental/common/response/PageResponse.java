package com.carrental.carrental.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {

    // ==============================
    // DATA
    // ==============================
    private List<T> content;

    // ==============================
    // PAGINATION METADATA
    // ==============================
    private int page;           // current page (0-based)
    private int size;           // page size
    private long totalElements; // total records
    private int totalPages;     // total pages

    private boolean first;
    private boolean last;
    private boolean empty;

    // ==============================
    // SORT INFO (OPTIONAL)
    // ==============================
    private String sortBy;
    private String sortDirection;

    // ==============================
    // STATIC MAPPER FROM SPRING PAGE
    // ==============================
    public static <T> PageResponse<T> from(Page<T> page) {
        return PageResponse.<T>builder()
                .content(page.getContent())
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .empty(page.isEmpty())
                .build();
    }

    // Overload with sort info
    public static <T> PageResponse<T> from(Page<T> page,
                                           String sortBy,
                                           String sortDirection) {
        return PageResponse.<T>builder()
                .content(page.getContent())
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .empty(page.isEmpty())
                .sortBy(sortBy)
                .sortDirection(sortDirection)
                .build();
    }

}
