package com.devsuperior.dscatalog.services;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dscatalog.dto.EmailDTO;
import com.devsuperior.dscatalog.entities.PasswordRecover;
import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.repositories.PasswordRecoverRepository;
import com.devsuperior.dscatalog.repositories.UserRepository;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;


@Service
public class AuthService {

    @Value("${email.password-recover.token.minutes}")
    private Long tokenMinutes;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRecoverRepository passwordRecoverRepository;


    public void CreateRecoverToken(EmailDTO body) {
        User user = userRepository.findByEmail(body.getEmail());
        if (user == null) {

            throw new ResourceNotFoundException("Email nao encontrado");
            
        }


        PasswordRecover entity = new PasswordRecover();
        entity.setEmail(body.getEmail());
        entity.setToken(UUID.randomUUID().toString());
        entity.setExpiration(Instant.now().plusSeconds(tokenMinutes * 60));

        entity = passwordRecoverRepository.save(entity);


    }



}
