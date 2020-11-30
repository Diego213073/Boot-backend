package com.spring.app.bootbackend.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorCode {

    private String code;
    private String message;

}
