package com.sanjeet.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjeet.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	

}
