package com.oliveiralucaspro.springrestclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

import com.oliveiralucaspro.springrestclient.service.ApiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final ApiService apiService;

    @GetMapping({ "", "/", "/index" })
    public String index() {
	return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange) {

	MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

	Integer limit = new Integer(map.get("limit").get(0));

	log.debug("Received Limit value: " + limit);
	// default if null or zero
	if (limit == null || limit == 0) {
	    log.debug("Setting limit to default of 10");
	    limit = 10;
	}

	model.addAttribute("users", apiService.getUsers(limit));

	return "userlist";
    }
}
