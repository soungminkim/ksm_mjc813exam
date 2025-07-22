package com.mjc813.contact_web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageDto {
    private Integer page;
    private Integer rws;
    private Integer off;
    private Long totRows;
    private Integer totPage;

    public Integer getPage() {
        return this.page == null || this.page <= 0 ? 1 : this.page;
    }

    public Integer getRws() {
        return this.rws == null ? 2 : this.rws;
    }

    public Integer getOff() {
        return (this.getPage() - 1) * this.getRws();
    }

    public Integer getTotPage() {
        return Integer.parseInt(
                String.format("%d", (this.getTotRows() + this.getRws() - 1) / (Long)Long.parseLong(this.getRws().toString()))
        );
    }
}
