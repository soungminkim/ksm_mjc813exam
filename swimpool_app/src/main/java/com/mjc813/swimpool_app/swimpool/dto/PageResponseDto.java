package com.mjc813.swimpool_app.swimpool.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponseDto<T> {
    private String search;
    private Integer row;        // 한 페이지 데이터 수 (null, 0, 음수 전부 처리)
    private Integer page;       // 현재 페이지 (null, 0, 음수 전부 처리)
    private Long totalRows;     // 전체 데이터 개수 (null/0 전부 처리)
    private List<T> list;

    // page 1 미만, null이면 1
    public int getPage() {
        if (page == null || page < 1) return 1;
        return page;
    }

    // row 1 미만, null이면 10
    public int getRow() {
        if (row == null || row < 1) return 10;
        return row;
    }

    // offset 자동 계산
    public int getOffset() {
        return (getPage() - 1) * getRow();
    }

    // totalPages 자동 계산
    public int getTotalPages() {
        long total = totalRows == null ? 0 : totalRows;
        int r = getRow();
        if (r == 0) return 1;
        return (int) ((total + r - 1) / r);
    }
}
