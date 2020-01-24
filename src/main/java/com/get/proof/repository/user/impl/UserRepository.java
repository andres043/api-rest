package com.get.proof.repository.user.impl;

import com.get.proof.model.entities.Usuario;
import com.get.proof.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepository implements UserRepositoryFacade {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<?> createUser(Iterable<Usuario> usuarios){
        return Optional.of(userRepository.saveAll(usuarios));
    }
}
