package guru.springframework.springbootpetclinic.services;

import guru.springframework.springbootpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Set<Owner> findAll();

    Owner findById(Long id);

    Owner findByLastName(String lastName);

    void save(Owner owner);

}
