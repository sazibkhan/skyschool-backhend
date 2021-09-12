package com.skyschool.skyschoolbackhend.repository;


import com.skyschool.skyschoolbackhend.entity.ProductPanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductPanel,String> {
  //  Optional<ProductPanel>findAllById(String id);

}
