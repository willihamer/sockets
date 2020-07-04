package com.spring.bakend.chat.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bakend.chat.models.documents.Mensaje;
import com.spring.bakend.chat.models.repository.ChatRepository;

@Service
public class ChatServiceImp implements ChatService{

	@Autowired
	private ChatRepository chatRep;
	
	@Override
	public List<Mensaje> obtenerUltimos10Mensajes() {
		return chatRep.findFirst10ByOrderByFechaDesc();
	}

	@Override
	public Mensaje guardar(Mensaje mensaje) {
		return chatRep.save(mensaje);
	}

}
