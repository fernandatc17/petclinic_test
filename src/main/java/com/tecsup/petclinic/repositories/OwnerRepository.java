package com.tecsup.petclinic.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;

/**
 * Repositorio para la entidad Owner.
 *
 * @author jgomezm
 *
 */
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    // Fetch owners by name
    List<Owner> findByName(String name);

    // Fetch owners by email
    List<Owner> findByEmail(String email);

    // Fetch owners by phone
    List<Owner> findByPhone(String phone);

    @Override
    List<Owner> findAll();
}
