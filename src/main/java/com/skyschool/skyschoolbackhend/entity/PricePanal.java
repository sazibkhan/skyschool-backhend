package com.skyschool.skyschoolbackhend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRICE")
public class PricePanal {

    @Id
    private String priceId;

    private Integer retails_price;
    private Integer purchase_price;
    private String bar_code;
    private Integer item_quantity;
    private String productSize;
   // private Data create_date;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    private ProductPanel productPanel;


}
