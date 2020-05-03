package com.oliveiralucaspro.springrestclient.service;

import java.util.List;

import com.oliveiralucaspro.api.domain.User;

public interface ApiService {

    List<User> getUsers(Integer limit);
}
