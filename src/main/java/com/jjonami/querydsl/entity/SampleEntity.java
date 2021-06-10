package com.jjonami.querydsl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class SampleEntity {

    @Id
    @GeneratedValue
    @Column(name = "idx")
    private Long idx;
}
