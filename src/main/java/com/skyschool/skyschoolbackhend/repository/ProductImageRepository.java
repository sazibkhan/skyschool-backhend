package com.skyschool.skyschoolbackhend.repository;


import com.skyschool.skyschoolbackhend.entity.ProductImagePanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImagePanel, String> {

    Optional<ProductImagePanel> findAllById(String id);

    Optional<ProductImagePanel> findAllByProductPanelId(String id);

}
