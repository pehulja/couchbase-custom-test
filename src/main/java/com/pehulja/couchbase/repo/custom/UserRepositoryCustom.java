package com.pehulja.couchbase.repo.custom;

import java.util.List;

import com.couchbase.client.protocol.views.Query;
import com.pehulja.couchbase.model.User;

public interface UserRepositoryCustom {
	public List<User> findByName(String	name);
	public User save(User entity);
}
