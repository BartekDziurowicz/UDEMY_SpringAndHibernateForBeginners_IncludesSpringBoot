package com.udemy.spring.mvc.utils;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class Customer {

    private String firstName;
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;
    @NotNull(message="is required")
    @Min(value=0, message="must be greater or equal to zero")
    @Max(value=10, message="must be less than or equal to 10")
    private Integer freePasses;
    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
    private String postalCode;
}
