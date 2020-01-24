package com.get.proof.service.user;

import com.get.proof.model.entities.Usuario;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<?> createUser() throws HttpClientErrorException;

}
