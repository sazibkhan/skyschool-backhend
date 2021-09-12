package com.skyschool.skyschoolbackhend.repository;

import com.skyschool.skyschoolbackhend.entity.CategoryPanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryPanel,String> {

    Optional<CategoryPanel>findAllById(String id);

}
