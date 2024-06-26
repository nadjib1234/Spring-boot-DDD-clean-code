package com.example.Domain.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Domain.Model.Adress;

@Repository
public interface AddressRepository extends JpaRepository<Adress, Long> {

    // Define specific query methods for Address entity as needed

}
