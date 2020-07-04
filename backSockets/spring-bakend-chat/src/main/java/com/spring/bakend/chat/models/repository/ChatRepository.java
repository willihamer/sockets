package com.spring.bakend.chat.models.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.bakend.chat.models.documents.Mensaje;

public interface ChatRepository extends  MongoRepository<Mensaje, String>{

	public List<Mensaje> findFirst10ByOrderByFechaDesc();
}
