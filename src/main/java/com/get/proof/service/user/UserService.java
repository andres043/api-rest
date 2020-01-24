package com.get.proof.service.user;

import com.get.proof.model.entities.Usuario;
import com.get.proof.repository.user.impl.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Value("${url.get.users}")
    String urlGetUsers;
    private UserRepository userRepository;
    private Gson gson;

    @Autowired
    public UserService(Gson gson, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.gson = gson;
    }

    @Override
    public Optional<?> createUser() throws HttpClientErrorException{
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(urlGetUsers, String.class);
        Iterable<Usuario> usersResponse = Arrays.asList(gson.fromJson(response.getBody(), Usuario[].class));
        return userRepository.createUser(usersResponse);
    }
}
