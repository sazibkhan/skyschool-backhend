package com.skyschool.skyschoolbackhend.repository;

import com.skyschool.skyschoolbackhend.entity.AdminPanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminPanel, String> {

    Optional<AdminPanel> findAllById(String id);


}
