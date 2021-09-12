package com.skyschool.skyschoolbackhend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class CustomerPanel {

    @Id
    private String id;

    private String cut_Name;

    private String cut_email;

    private String cut_phone;

    private String cut_address;

    private String productName;

    private Double productBasedPrice;

    private String productQuantity;

    private Double productTotalPrice;

}
