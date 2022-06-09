package com.postman.webservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String emailId;

    private String password;

    @OneToMany
    private List<SessionDetail> sessions;

}
