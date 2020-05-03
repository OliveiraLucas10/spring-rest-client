package com.oliveiralucaspro.springrestclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.oliveiralucaspro.api.domain.User;
import com.oliveiralucaspro.api.domain.UserData;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate = new RestTemplate();;

    private final String api_url;

    public ApiServiceImpl(@Value("${api.url}") String api_url) {
	this.api_url = api_url;
    }

    @Override
    public List<User> getUsers(Integer limit) {

	UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url).queryParam("limit", limit);

	UserData userData = restTemplate.getForObject(uriBuilder.toUriString(), UserData.class);
	return userData.getData();
    }
}
