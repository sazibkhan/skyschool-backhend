package com.skyschool.skyschoolbackhend.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADMIN_PANEL")
public class AdminPanel {

    @Id
    private String id;

    private String adminName;

    private String adminEmail;

    private String password;

    private String adminPhone;

    private String gender;

    //private Data dateOfBarth;


}
