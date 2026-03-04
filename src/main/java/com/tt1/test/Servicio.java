package com.tt1.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Servicio {
	private Repositorio repo = new Repositorio();
    private MailerStub mailer = new MailerStub();

    public void crearTarea(String nombre, Date fecha) {
        if (nombre != null && nombre.length() > 0) { 
            ToDo nueva = new ToDo(nombre, fecha);
            repo.guardarNuevo(nueva); 
            verificarAlertas(); 
        }
    }

    public void agregarEmail(String email) {
        if (email != null) {
            repo.guardarEmail(email);
            verificarAlertas(); 
        }
    }

    public void marcarFinalizada(String nombre) {
        repo.marcarCompletado(nombre); 
        verificarAlertas(); 
    }

    public List<ToDo> consultarPendientes() {
        verificarAlertas();
        List<ToDo> pendientes = new ArrayList<>();
        
        for (ToDo t : repo.getDb().obtenerTodas()) {
            if (!t.isCompletado()) {
                pendientes.add(t);
            }
        }
        return pendientes;
    }

    private void verificarAlertas() {
        Date hoy = new Date(); 
        List<ToDo> caducadas = new ArrayList<>();

        for (ToDo t : repo.getDb().obtenerTodas()) {
            if (!t.isCompletado() && t.getFechaLimite().before(hoy)) {
                caducadas.add(t);
            }
        }

        if (caducadas.size() > 0) {
            for (String email : repo.getDb().obtenerEmails()) {
                mailer.enviarCorreo(email, "Alerta: Tareas pendientes caducadas."); 
            }
        }
    }
}
