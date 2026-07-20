package com.devsuperior.dscatalog.dto;

public class  UserInsertDTO extends UserDTO {
    private static final long serialVersionUID = 1L;

    private String password;


    UserInsertDTO(){
        super();
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    

}
