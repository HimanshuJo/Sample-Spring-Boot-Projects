package com.capgemini.h2test.repository;

import com.capgemini.h2test.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>
{
}
