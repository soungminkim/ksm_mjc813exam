package com.mjc813.mpacrud.animal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    private String searchType;
    private String searchWord;
    private Integer rowsOnePage;
    private Integer page;
    private Integer offset;

    public String getSearchType() {
        return this.searchType == null || "".equals(this.searchType) ? "name" : this.searchType;
    }

    public String getSearchWord() {
        return this.searchWord == null ? "" : this.searchWord;
    }

    public Integer getRowsOnePage() {
        return this.rowsOnePage == null ? 10 : this.rowsOnePage;
    }

    public Integer getPage() {
        return this.page == null ? 1 : this.page;
    }

    public Integer getOffset() {
        return (this.getPage()-1) * this.getRowsOnePage();
    }
}
