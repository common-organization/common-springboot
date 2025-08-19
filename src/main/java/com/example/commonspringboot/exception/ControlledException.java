package com.example.commonspringboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ControlledException extends RuntimeException {
    private final ErrorMessage errorCode;
}
