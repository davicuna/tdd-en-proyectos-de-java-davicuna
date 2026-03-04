package com.tt1.test;

public class Repositorio {
	private DBStub db = new DBStub();

    public ToDo buscarPorNombre(String nombre) {
    	for (ToDo t : db.obtenerTodas()) {
            if (t.getNombre().equals(nombre)) {
                return t;
            }
        }        
        return null;
    }
                
    public void marcarCompletado(String nombre) {
        ToDo t = buscarPorNombre(nombre);
        if (t != null) {
            t.setCompletado(true);
            db.actualizarTarea(t);
        }
    }
    public void guardarNuevo(ToDo todo) { 
    	db.insertarTarea(todo); 
    }
    public void guardarEmail(String email) { 
    	db.guardarEmail(email); 
    }
    public DBStub getDb() { 
    	return db; 
    }
}