package vn.mikademy.backend.common.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
@Getter
@Builder
public class PaginationResponse<T> {

    private List<T> items;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    public static <T> PaginationResponse<T> empty(int page, int size) {
        return PaginationResponse.<T>builder()
                .items(Collections.emptyList())
                .page(page)
                .size(size)
                .totalElements(0)
                .totalPages(0)
                .build();
    }
}