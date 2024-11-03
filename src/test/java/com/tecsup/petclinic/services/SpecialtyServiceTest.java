package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class SpecialtyServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(PetServiceTest.class);

	@Autowired
	private OwnerService ownerService;

	@BeforeEach
	public void setUp() {
		ownerService = new OwnerService();
		// Crear y agregar el Owner al servicio
		String nombreOriginal = "Prueba";
		Long id = 1L;
		ownerService.create(id, nombreOriginal);
	}


	//Metodo de prueba usando JUnit
	@Test
	public void testCREATE1() {
		//Datos para la creacion
		Long id = 1L;
		String name = "Prueba";

		//Objeto esperado
		Owner esperado = new Owner(id, name);


		//Usar el metodo para probar
		Owner resultado = ownerService.create(id, name);

		//Registro de la informacion
		logger.info("" + resultado);

		//Comparacion
		Assertions.assertEquals(esperado.getName(), resultado.getName());
		Assertions.assertEquals(esperado.getId(), resultado.getId());
	}

	@Test
	public void testCREATE() {
		//Datos para la creacion
		Long id = 1L;
		String name = "Prueba";

		// Objeto esperado
		Owner esperado = new Owner(id, name);

		// Usar el metodo para probar
		Owner resultado = ownerService.create(id, name);

		// Registro de la información
		logger.info("Testing CREATE: Result - {}", resultado);

		// Comparacion
		Assertions.assertEquals(esperado.getName(), resultado.getName(), "El nombre del Owner no coincide");
		Assertions.assertEquals(esperado.getId(), resultado.getId(), "El ID del Owner no coincide");
	}

	@Test
	public void testUPDATE() {
		String nombreOriginal = "Prueba";
		String nombreActualizado = "Prueba2";
		String otro="Prueba3";
		Long id = 1L;

		Owner actualizado = ownerService.update(id, nombreActualizado);

		// Registro de la información
		logger.info("Testing UPDATE: ID - {}, Antiguo NOMBRE - {}, nuevo Nombre - {}", id, nombreOriginal, nombreActualizado);

		// Verifica que el nombre haya cambiado al nuevo nombre
		Assertions.assertEquals(nombreActualizado, actualizado.getName(), "El nombre no fue actualizado correctamente");
		// Verifica que el ID siga siendo el mismo
		Assertions.assertEquals(id, actualizado.getId(), "El ID del Owner no debe cambiar");
	}

	@Test
	public void testDELETE() {
		Long id = 1L;

		// Realiza la eliminación
		ownerService.delete(id);

		// Registro de la información
		logger.info("Testing DELETE: Owner con ID - {} eliminado", id);

		// Comprobar la eliminacion
		Assertions.assertNull(ownerService.findById(id), "El Owner no debería existir en el repositorio después de la eliminación");
	}

	@Test
	public void testFIND() {
		Long id = 1L;
		String name = "Prueba";

		Owner buscando = ownerService.findById(id);

		// Registro de la información
		logger.info("Testing FIND: Buscando al Owner con ID - {}", id);

		// Verificamos que se haya encontrado
		Assertions.assertNotNull(buscando, "Owner no debería ser null");
		Assertions.assertEquals(buscando.getName(), name, "El nombre del Owner no coincide");
	}



}
