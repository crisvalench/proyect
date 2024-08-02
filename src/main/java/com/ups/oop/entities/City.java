package com.ups.oop.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

//Ciudad
public class City extends BaseEntity {
    BaseEntity id;
    private String idCity;
    private String nameCity;
}
