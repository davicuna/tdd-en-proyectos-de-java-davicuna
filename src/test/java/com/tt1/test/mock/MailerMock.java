package com.tt1.test.mock;

import com.tt1.test.MailerStub;

public class MailerMock extends MailerStub {
	public int correosEnviados = 0;
    public String ultimoMensaje = "";

    
    public boolean enviarCorreo(String direccion, String mensaje) {
        correosEnviados++;
        ultimoMensaje = mensaje;
        
        return true; 
    }

}
