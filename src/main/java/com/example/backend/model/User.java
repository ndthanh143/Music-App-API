package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "user")
public class User {
    @Id
    private String id;

//    @Column(length = 50, nullable = false)
    private String name;

//    @Column(length = 10, nullable = false)
    private String phone;

//    @Column(length = 50, nullable = false)
    private String email;

    @JsonIgnore
//    @Column(length = 50, nullable = false)
    private String password;

    private List<String> roles=new ArrayList<>();

    private boolean trangThai = true;
    public User(String name, String email, String password, String phone, List<String> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.roles = roles;
    }
}
