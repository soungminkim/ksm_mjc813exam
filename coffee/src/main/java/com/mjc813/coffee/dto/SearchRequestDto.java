package com.mjc813.coffee.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    private String search;
    private Integer row;
    private Integer page;
    private Integer offset;

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
}
