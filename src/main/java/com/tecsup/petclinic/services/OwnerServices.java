package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import java.util.List;
import java.util.Optional;

public interface OwnerServices {

    Owner save(Owner owner);

    void deleteById(Integer id);
}
