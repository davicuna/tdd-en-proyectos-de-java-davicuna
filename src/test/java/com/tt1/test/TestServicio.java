package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestServicio {
	private Servicio servicio;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
    public void setUp() {
        servicio = new Servicio();
    }

	@AfterEach
	void tearDown() throws Exception {
	}

    @Test
    public void testCrearYConsultarPendientes() {
        servicio.crearTarea("Tarea 1", null);
        assertEquals(1, servicio.consultarPendientes().size());
        assertEquals("Tarea 1", servicio.consultarPendientes().get(0).getNombre());
    }

    @Test
    public void testAlertaTareasCaducadas() {
        
        servicio.agregarEmail("admin@universidad.es");
        
        servicio.crearTarea("Tarea Caducada", null);
        
        assertFalse(servicio.consultarPendientes().isEmpty());
    }

}
