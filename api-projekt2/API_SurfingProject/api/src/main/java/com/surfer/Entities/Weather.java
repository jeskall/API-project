package com.surfer.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Weather")

public class Weather {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "waves")
    private int waves;

    @Column(name = "sharks_type")
    private String sharksType;

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "wind")
    private int wind;

    @ManyToOne
    @JoinColumn(name = "beach_id")

    @JsonIgnore
    private Beach beach;

}
