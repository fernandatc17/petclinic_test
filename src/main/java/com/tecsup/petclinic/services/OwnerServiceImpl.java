package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;

/**
 * Implementación del servicio Owner.
 *
 * @author jgomezm
 *
 */
@Service
@Slf4j
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    /**
     * Crea un nuevo dueño.
     *
     * @param owner
     * @return Owner
     */
    @Override
    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    /**
     * Actualiza un dueño existente.
     *
     * @param owner
     * @return Owner
     */
    @Override
    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }

    /**
     * Elimina un dueño por su ID.
     *
     * @param id
     * @throws OwnerNotFoundException
     */
    @Override
    public void delete(Integer id) throws OwnerNotFoundException {
        Owner owner = findById(id);
        ownerRepository.delete(owner);
    }

    /**
     * Busca un dueño por su ID.
     *
     * @param id
     * @return Owner
     * @throws OwnerNotFoundException
     */
    @Override
    public Owner findById(Integer id) throws OwnerNotFoundException {
        Optional<Owner> owner = ownerRepository.findById(id);

        if (!owner.isPresent())
            throw new OwnerNotFoundException("Owner not found...!");

        return owner.get();
    }

    /**
     * Busca dueños por nombre.
     *
     * @param name
     * @return List<Owner>
     */
    @Override
    public List<Owner> findByName(String name) {
        List<Owner> owners = ownerRepository.findByName(name);
        owners.forEach(owner -> log.info("" + owner));
        return owners;
    }

    /**
     * Busca todos los dueños.
     *
     * @return List<Owner>
     */
    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}
