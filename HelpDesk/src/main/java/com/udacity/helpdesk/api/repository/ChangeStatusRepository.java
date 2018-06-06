package com.udacity.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.udacity.helpdesk.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String> {
	
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);
}
