package com.spring.bakend.chat.controllers;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.spring.bakend.chat.models.documents.Mensaje;
import com.spring.bakend.chat.models.services.ChatService;

@Controller
public class chatController {

	@Autowired
	private ChatService chatService;

//	Permite personalizar el sendto de la peticion agregando parametros, de tal forma que la peticion no llegue 
	// a todos por ejemplo: los que tienen id 1 podran recibir x notificacion y los que tienen id 2 y notificacion
	@Autowired
	private SimpMessagingTemplate webSocket;

	private String[] colores = { "red", "orange", "green", "blue", "purple", "magenta" };

//	la anotacion sendto es la que permite que la informacion que envia un cliente sea enaviada a los demas
//	los clientes deben estar suscritos al evento chat
//	el valor del sendto debe ser igual al que se configuro en websocketconfig 
	@MessageMapping("/mensaje")
	@SendTo("/chat/message")
	public Mensaje recibeMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());

		if (mensaje.getTipo().equals("NUEVO_USUARIO")) {

			mensaje.setColor(colores[new Random().nextInt(colores.length)]);
			mensaje.setTexto("nuevo usuario");
		} else {
			chatService.guardar(mensaje);
		}

		return mensaje;
	}

	@MessageMapping("/escribiendo")
	@SendTo("/chat/escribiendo")
	public String estaEscribiendo(String username) {
		return username.concat(" está escribiendo...");
	}

	@MessageMapping("/historial")
	public void historial(String clienteId) {
		System.out.println(clienteId);
		webSocket.convertAndSend("/chat/historial/" + clienteId, chatService.obtenerUltimos10Mensajes());

	}

}
