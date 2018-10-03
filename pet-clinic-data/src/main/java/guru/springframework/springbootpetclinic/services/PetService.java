package guru.springframework.springbootpetclinic.services;

import guru.springframework.springbootpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Set<Pet> findAll();

    Pet findById(Long id);

    void save(Pet pet);

}
