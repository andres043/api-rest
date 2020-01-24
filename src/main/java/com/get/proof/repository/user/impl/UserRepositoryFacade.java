package com.get.proof.repository.user.impl;

import com.get.proof.model.entities.Usuario;

import java.util.Optional;

public interface UserRepositoryFacade {

    Optional<?> createUser(Iterable<Usuario> usuarios);

}
