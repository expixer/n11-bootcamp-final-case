package com.sezginsevinc.finalcase.repository;

import com.sezginsevinc.finalcase.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
