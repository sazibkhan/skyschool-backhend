package com.skyschool.skyschoolbackhend.repository;



import com.skyschool.skyschoolbackhend.entity.CustomerPanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository  extends JpaRepository<CustomerPanel,String> {

   // Optional<CustomerPanel>findAllById(String id);
}
