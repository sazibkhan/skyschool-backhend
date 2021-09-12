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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class ProductPanel {

    @Id
    private String id;
    private String productName;
    private int productPrice;


    private String categoryPanel;

    private String imageName;
    private String imageUrl;
    private Long imageSize;



}
