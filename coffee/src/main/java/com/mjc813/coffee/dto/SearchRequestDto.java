package com.mjc813.coffee.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    private String search;
    private Integer row;
    private Integer page;
    private Integer offset;
    private Long totalRows;
    private Integer totalPages;

    public String getSearch() {
        return this.search == null ? "" : this.search;
    }

    public Integer getRow() {
        return this.row == null ? 10 : this.row;
    }

    public Integer getPage() {
        return this.page == null ? 1 : this.page;
    }

    public Integer getOffset() {
        return (this.getPage()-1) * this.getRow();
    }

    public Long getTotalRows() {
        return this.totalRows == null ? 0 : this.totalRows;
    }

    public Integer getTotalPage() {
        int rowPerPage = getRow();
        if(rowPerPage == 0) return 1;
        return (int)((getTotalRows() + rowPerPage - 1) / rowPerPage);
    }
}
