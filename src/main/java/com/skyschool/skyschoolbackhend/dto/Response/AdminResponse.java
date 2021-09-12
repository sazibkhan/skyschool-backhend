package com.skyschool.skyschoolbackhend.dto.Response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminResponse {

    private String id;
    private String adminName;

    private String adminEmail;

    private String password;

    private String adminPhone;

    private String gender;

    //private Data dateOfBarth;
}
