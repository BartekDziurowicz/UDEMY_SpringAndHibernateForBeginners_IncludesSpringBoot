package com.udemy.spring.mvc.utils;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Customer {

    private String firstName;
    @NotNull
    @Size(min=1, message="is required")
    private String lastName;
}
