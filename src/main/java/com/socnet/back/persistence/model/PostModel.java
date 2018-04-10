package com.socnet.back.persistence.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "posts")
public class PostModel {
    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "id", unique = true, nullable = false, precision = 15, scale = 0)
    private Long id;

    @Column(name = "owner", nullable = false)
    private String owner;

    @Column(name = "text", nullable = false)
    private String text;

}
