package com.pehulja.couchbase.repo;

import java.util.List;

import org.springframework.data.couchbase.core.view.View;
import org.springframework.data.repository.CrudRepository;

import com.couchbase.client.protocol.views.Query;
import com.pehulja.couchbase.model.User;
import com.pehulja.couchbase.repo.custom.UserRepositoryCustom;

public interface UserRepository extends CrudRepository<User, String>, UserRepositoryCustom{
	@View(designDocument = "user", viewName = "findByName")
	public List<User> findByName(Query query);
}
