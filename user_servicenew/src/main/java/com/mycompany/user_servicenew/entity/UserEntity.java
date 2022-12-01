package com.mycompany.user_servicenew.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="User_Table")
@NoArgsConstructor
public class UserEntity

    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String name;
        private String email;
        private String password;
        private  String phone;
    }


