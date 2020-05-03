package com.oliveiralucaspro.springrestclient.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.ResourceAccessException;

import com.oliveiralucaspro.api.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles({ "unit-tests", "test" })
public class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @LocalServerPort
    int randomServerPort;

    @Before
    public void setUp() throws Exception {
    }

    @Test(expected = ResourceAccessException.class)
    public void testGetUsers() throws Exception {

	List<User> users = apiService.getUsers(3);

//	assertEquals(3, users.size());
    }
}
