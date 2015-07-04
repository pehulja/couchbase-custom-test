package com.pehulja.couchbase.repo.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Repository;

import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.pehulja.couchbase.model.User;
import com.pehulja.couchbase.repo.custom.UserRepositoryCustom;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom{
	@Autowired
	CouchbaseTemplate couchbaseTemplate;
	
	private final String KEY = "USER::KEY";

	@Override
	public List<User> findByName(String name) {
		Query query = new Query();
		query.setKey(ComplexKey.of(name));
		return couchbaseTemplate.findByView("user", "findByName", query, User.class);
	}

	@Override
	public User save(User entity) {
		System.out.println("!!! CUSTOMIZED");
		long key = couchbaseTemplate.getCouchbaseClient().incr(KEY, 1l, 1l);
		entity.setId(Long.toString(key));
		couchbaseTemplate.save(entity);
		return entity;
	}
	
}
