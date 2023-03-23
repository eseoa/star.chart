package com.blue.water.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Schema
public record UserUpdateRequest(

        @NotNull
        String firstName,

        @NotNull
        String lastName,

        @Email
        @NotNull
        String email,

        @NotNull
        String password

) {

}
