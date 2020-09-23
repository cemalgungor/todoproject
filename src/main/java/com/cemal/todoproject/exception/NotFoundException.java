package com.cemal.todoproject.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public NotFoundException(String msg) {
        super(msg);
    }
}
