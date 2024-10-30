package com.tecsup.petclinic.exception;



/**
 * Excepción que se lanza cuando no se encuentra un propietario.
 *
 * @author jgomezm
 *
 */
public class OwnerNotFoundException extends Exception {

  private static final long serialVersionUID = 1L;

  public OwnerNotFoundException(String message) {
    super(message);
  }
}
