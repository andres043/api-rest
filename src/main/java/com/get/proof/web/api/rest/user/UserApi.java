package com.get.proof.web.api.rest.user;

import com.get.proof.commons.constants.api.user.EndpointUserApi;
import com.get.proof.model.entities.Usuario;
import com.get.proof.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Optional;

@RestController
@RequestMapping(EndpointUserApi.API_USER)
public class UserApi implements IUserApi{

    @Autowired
    private UserService userService;

    @Override
    @ResponseBody
    @PostMapping(EndpointUserApi.CREATE)
    public ResponseEntity<?> createUser() {
        try{
            Optional<?> users = userService.createUser();
            return ResponseEntity.status(users.isPresent() ? HttpStatus.OK : HttpStatus.CONFLICT)
                    .body(users.isPresent() ? users.get() : users.get().toString());
        }catch (HttpClientErrorException e){
            return ResponseEntity.status(e.getRawStatusCode()).build();
        }
        catch (Exception e){
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
