package com.pehulja.couchbase.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Service;

import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.pehulja.couchbase.model.User;
import com.pehulja.couchbase.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	@Autowired
	CouchbaseTemplate couchbaseTemplate;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	public void doSomeStuff() {
		repository.deleteAll();

		User user = new User();
		user.setId(Integer.toString(new Random().nextInt()));
		user.setName("Lala");

		user = repository.save(user);

		Query query = new Query();
		query.setKey(ComplexKey.of("Lala"));
		
		LOGGER.info("Size of retruned collection : " + repository.findByName(query).size());
		LOGGER.info("Size of retruned collection : " + repository.findByName("Lala").size());

	}
}
