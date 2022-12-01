package com.mycompany.user_servicenew.exception;

import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;

@Getter
@Setter
public class ErrorModel
{
    private String code;
    private String msg;
}
