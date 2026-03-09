package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class TestServicio {
    private Servicio servicio;

    @BeforeEach
    public void setUp() {
        servicio = new Servicio();
    }

    @Test
    public void testCrearYConsultarPendientes() {
        // Usamos la fecha actual para evitar el error de NullPointerException
        Date hoy = new Date(); 
        servicio.crearTarea("Tarea 1", hoy);
        
        assertEquals(1, servicio.consultarPendientes().size());
        assertEquals("Tarea 1", servicio.consultarPendientes().get(0).getNombre());
    }

    @Test
    public void testAlertaTareasCaducadas() {
        servicio.agregarEmail("admin@universidad.es");
        
        // Creamos una fecha del pasado (ayer) para forzar la alerta
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1); 
        Date ayer = cal.getTime();
        
        servicio.crearTarea("Tarea Caducada", ayer);
        
        // Verificamos que la lista de pendientes incluya la tarea caducada
        assertFalse(servicio.consultarPendientes().isEmpty());
    }
}
