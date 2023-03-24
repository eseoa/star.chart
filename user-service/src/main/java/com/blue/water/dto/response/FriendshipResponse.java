package com.blue.water.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema
public record FriendshipResponse(

        @NotNull
        Long id,

        @NotNull
        Long friendId

) {
}
