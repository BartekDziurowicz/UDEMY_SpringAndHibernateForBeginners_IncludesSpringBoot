package com.udemy.spring.mvc.utils;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Customer {

    private String firstName;
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;
    @Min(value=0, message="must be greater or equal to zero")
    @Max(value=10, message="must be less than or equal to 10")
    private int freePasses;
}
