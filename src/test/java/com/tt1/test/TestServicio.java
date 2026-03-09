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
        Date hoy = new Date(); 
        servicio.crearTarea("Tarea 1", hoy);
        
        assertEquals(1, servicio.consultarPendientes().size());
        assertEquals("Tarea 1", servicio.consultarPendientes().get(0).getNombre());
    }

    @Test
    public void testAlertaTareasCaducadas() {
        servicio.agregarEmail("admin@universidad.es");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1); 
        Date ayer = cal.getTime();

        servicio.crearTarea("Tarea Caducada", ayer);
        
        assertFalse(servicio.consultarPendientes().isEmpty());
    }
}

}
