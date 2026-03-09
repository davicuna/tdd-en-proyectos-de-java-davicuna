package com.tt1.test;

import java.util.*;

public class DBStub {
	private Map<String, ToDo> tareas = new HashMap<>();
    private List<String> agendaEmails = new ArrayList<>();

    public void insertarTarea(ToDo tarea) { tareas.put(tarea.getNombre(), tarea); }
    public List<ToDo> obtenerTodas() { return new ArrayList<>(tareas.values()); }
    public void actualizarTarea(ToDo tarea) { tareas.put(tarea.getNombre(), tarea); }
    public void eliminarTarea(String nombre) { tareas.remove(nombre); }
    public void guardarEmail(String email) { agendaEmails.add(email); }
    public List<String> obtenerEmails() { return agendaEmails; }
}
