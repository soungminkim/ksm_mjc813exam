package com.mjc813.band_jpa.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "BandEntity")
@Table(name = "band_tbl")
public class BandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true, nullable = false)
    private String name;

    @Column(length = 20, unique = true, nullable = false)
    private String leader;

    private String guitarFirst;

    private String guitarSecond;

    private String drum;

    private String bass;

    private String keyboard;

    private String vocal;
}
