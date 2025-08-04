package com.petistaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petistaan.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    // custom query methods can be added later
}
