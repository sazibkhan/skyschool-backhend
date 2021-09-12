package com.skyschool.skyschoolbackhend.repository;


import com.skyschool.skyschoolbackhend.entity.PricePanal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PricePanal, String> {

}
