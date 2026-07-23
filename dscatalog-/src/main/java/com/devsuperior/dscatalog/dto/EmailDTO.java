package com.devsuperior.dscatalog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDTO { 


    
    @NotBlank(message = "campo obrigatorio")
    @Email(message = "email invalido")
    private String email;


    public EmailDTO(){}


    public EmailDTO(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    
}
