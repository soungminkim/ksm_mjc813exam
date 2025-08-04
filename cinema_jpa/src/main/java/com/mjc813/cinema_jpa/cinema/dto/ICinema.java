package com.mjc813.cinema_jpa.cinema.dto;

public interface ICinema {

    public Long getId();

    public String getName();

    public Long getGenreId();

    public String getPlayTime();

    public String getCasts();

    public String getDescription();

    public Integer getRestrictAge();

    public void setId(final Long id);

    public void setName(final String name);

    public void setGenreId(final Long genreId);

    public void setPlayTime(final String playTime);

    public void setCasts(final String casts);

    public void setDescription(final String description);

    public void setRestrictAge(final Integer restrictAge);

    default void copyMembers(ICinema from) {
        setId(from.getId());
        setName(from.getName());
        setGenreId(from.getGenreId());
        setPlayTime(from.getPlayTime());
        setCasts(from.getCasts());
        setDescription(from.getDescription());
        setRestrictAge(from.getRestrictAge());
    }
}
