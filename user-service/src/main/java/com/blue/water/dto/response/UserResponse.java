package com.blue.water.dto.response;

import com.blue.water.dto.request.ImageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema
public record UserResponse(

        @NotNull
        Long id,

        @NotNull
        String firstName,

        @NotNull
        String lastName,

        @Email
        @NotNull
        String email,

        List<@Valid ImageResponse> imageResponses,

        List<@Valid FriendshipResponse> friendshipResponses,

        List<@Valid FriendRequestResponse> friendRequestResponses

) {
}
