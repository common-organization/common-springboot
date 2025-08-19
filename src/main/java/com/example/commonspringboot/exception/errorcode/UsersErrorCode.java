package com.example.commonspringboot.exception.errorcode;

import com.example.commonspringboot.exception.ErrorMessage;

public interface UsersErrorCode {
    ErrorMessage UserNotFound = new ErrorMessage(-401, "사용자를 찾을 수 없습니다.");
}
