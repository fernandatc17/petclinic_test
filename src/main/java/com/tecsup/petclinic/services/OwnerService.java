package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

/**
 * Interfaz para los servicios de la entidad Owner.
 *
 * @author jgomezm
 *
 */
public interface OwnerService {

    /**
     * Crea un nuevo dueño.
     *
     * @param owner
     * @return Owner
     */
    Owner create(Owner owner);

    /**
     * Actualiza un dueño existente.
     *
     * @param owner
     * @return Owner
     */
    Owner update(Owner owner);

    /**
     * Elimina un dueño por su ID.
     *
     * @param id
     * @throws OwnerNotFoundException
     */
    void delete(Integer id) throws OwnerNotFoundException;

    /**
     * Busca un dueño por su ID.
     @param id
      * @return Owner
     * @throws OwnerNotFoundException
     */
    Owner findById(Integer id) throws OwnerNotFoundException;

    /**
     * Busca dueños por nombre.
     *
     * @param name
     * @return List<Owner>
     */
    List<Owner> findByName(String name);

    /**
     * Busca todos los dueños.
     *
     * @return List<Owner>
     */
    List<Owner> findAll();
}
