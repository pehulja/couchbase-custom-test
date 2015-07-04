package com.pehulja.couchbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pehulja.couchbase.conf.Config;
import com.pehulja.couchbase.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CouchbaseDemoApplication.class)
public class CouchbaseDemoApplicationTests {
	
	@Autowired
	UserService service;
	
	@Test
	public void contextLoads() {
		service.doSomeStuff();
	}

}
