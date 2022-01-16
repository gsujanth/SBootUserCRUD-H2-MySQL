package com.training.springbootdemo.controller;

import com.training.springbootdemo.model.AdvancedUser;
import com.training.springbootdemo.model.FullName;
import com.training.springbootdemo.service.AdvancedUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/advancedUsers")
public class AdvancedUserController {

    @Autowired
    private AdvancedUserService advancedUserService;

    @GetMapping("lastName/{lastName}")
    public ResponseEntity<AdvancedUser> getUserByLastName(@PathVariable String lastName) {
        try {
            return new ResponseEntity<>(advancedUserService.getUserByLastName(lastName), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred in getUserByLastName(): {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("firstName/{firstName}")
    public ResponseEntity<AdvancedUser> getUserByFirstName(@PathVariable String firstName) {
        try {
            return new ResponseEntity<>(advancedUserService.getUserByFirstName(firstName), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred in getUserByFirstName(): {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/fullNames")
    public ResponseEntity<List<FullName>> getAdvancedUsersFullNames() {
        try {
            return new ResponseEntity<>(advancedUserService.getAdvancedUsersFullNames(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred in getAdvancedUsersFullNames(): {}", e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public void createAdvancedUser(@RequestBody @Valid AdvancedUser advancedUser) {
        advancedUserService.createAdvancedUser(advancedUser);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(objectError -> {
            String name = ((FieldError) objectError).getField();
            String message = objectError.getDefaultMessage();
            validationErrors.put(name, message);
        });
        log.error("{}", validationErrors);
        return validationErrors;
    }
}
