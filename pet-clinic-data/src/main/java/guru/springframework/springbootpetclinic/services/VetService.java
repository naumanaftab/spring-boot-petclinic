package guru.springframework.springbootpetclinic.services;

import guru.springframework.springbootpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Set<Vet> findAll();

    Vet findById(Long id);

    Vet findByLastName(String lastName);

    void save(Vet vet);

}
