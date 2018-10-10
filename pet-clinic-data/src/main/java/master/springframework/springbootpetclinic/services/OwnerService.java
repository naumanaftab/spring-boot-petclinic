package master.springframework.springbootpetclinic.services;

import master.springframework.springbootpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
