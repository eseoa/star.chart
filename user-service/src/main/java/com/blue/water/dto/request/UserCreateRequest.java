package com.blue.water.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema
public record UserCreateRequest(

        @NotNull
        String firstName,

        @NotNull
        String lastName,

        @Email
        @NotNull
        String email,

        @NotNull
        String password,

        List<@Valid ImageRequest> imageRequests


) {
}
