package com.oliveiralucaspro.springrestclient.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oliveiralucaspro.api.domain.User;
import com.oliveiralucaspro.api.domain.UserData;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<User> getUsers(Integer limit) {

	UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit=" + limit, UserData.class);
	return userData.getData();
    }
}
