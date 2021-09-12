package com.skyschool.skyschoolbackhend.dto.Request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequest {

    private String id;

    private String adminName;

    private String adminEmail;

    private String password;

    private String adminPhone;

    private String gender;

   // private Data dateOfBarth;



}
