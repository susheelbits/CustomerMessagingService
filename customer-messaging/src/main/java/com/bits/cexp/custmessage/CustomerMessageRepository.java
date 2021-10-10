package com.bits.cexp.custmessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bits.cexp.custmessage.model.Customer;


@Repository
public interface CustomerMessageRepository extends JpaRepository<Customer, Long> {

}