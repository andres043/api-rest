package com.get.proof.repository.user;

import com.get.proof.model.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<Usuario, String> {
}
