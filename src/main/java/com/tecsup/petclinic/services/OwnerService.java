package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class OwnerService {

    private final HashMap<Long, Owner> owner = new HashMap<>();

    public Owner create(Long id, String name) {
        Owner newOwner = new Owner(id, name);
        owner.put(id, newOwner);
        return newOwner;
    }

    public Owner update(Long id, String name) {
        Owner updatedOwner = new Owner(id, name);
        owner.put(id, updatedOwner);
        return updatedOwner;
    }

    public Owner delete(Long id) {
        return owner.remove(id);
    }

    public Owner findById(Long id) {
        return owner.get(id);
    }

}
