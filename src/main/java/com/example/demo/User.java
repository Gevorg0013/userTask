
package com.example.demo;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document
@Data
public class User {

    @Id
    private long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String postZip;
    private String country;
    private String password;
    private String pan;
    private String expdate;
    private Integer cvv;
    private String role;

}
