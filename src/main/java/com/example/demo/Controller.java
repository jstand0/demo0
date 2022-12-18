package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserServiceController {
    private static Map<String, USER> UserRepo = new HashMap<>();
    static {
        USER andrew = new USER();
        andrew.setId("1");
        andrew.setName("Andrew");
        UserRepo.put(andrew.getId(), andrew);

        USER dmitry = new USER();
        dmitry.setId("2");
        dmitry.setName("Dmitry");
        UserRepo.put(dmitry.getId(), dmitry);
    }

    @RequestMapping(value = "/User/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        UserRepo.remove(id);
        return new ResponseEntity<>("User is deleted.", HttpStatus.OK);
    }

    @RequestMapping(value = "/User/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody USER user) {
        UserRepo.remove(id);
        user.setId(id);
        UserRepo.put(id, user);
        return new ResponseEntity<>("Data about User is updated.", HttpStatus.OK);
    }

    @RequestMapping(value = "/User", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody USER user) {
        UserRepo.put(user.getId(), user);
        return new ResponseEntity<>("New User is added in table.", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/User")
    public ResponseEntity<Object> getUser() {
        return new ResponseEntity<>(UserRepo.values(), HttpStatus.OK);
    }
}