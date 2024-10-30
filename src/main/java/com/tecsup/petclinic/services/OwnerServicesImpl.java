package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository; // Asegúrate de tener este repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerServicesImpl implements OwnerServices {
    @Autowired
    private final OwnerRepository ownerRepository;

    public OwnerServicesImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteById(Integer id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}
