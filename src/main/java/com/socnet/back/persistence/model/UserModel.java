package com.socnet.back.persistence.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "id", unique = true, nullable = false, precision = 15, scale = 0)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Lob
    @Column(name = "avatar")
    private String avatar;

    @Column(name = "sex")
    private String sex;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "city")
    private String city;
}
