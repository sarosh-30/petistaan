package com.petistaan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petistaan.entity.Pet;
import com.petistaan.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet updatePet(Long id, Pet pet) {
        Optional<Pet> existing = petRepository.findById(id);
        if (existing.isPresent()) {
            Pet p = existing.get();
            p.setName(pet.getName());
            p.setBreed(pet.getBreed());
            p.setAge(pet.getAge());
            p.setHealthStatus(pet.getHealthStatus());
            return petRepository.save(p);
        } else {
            return null;
        }
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
