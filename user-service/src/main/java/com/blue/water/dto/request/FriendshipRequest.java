package com.blue.water.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema
public record FriendshipRequest(
        @NotNull
        Long friendId
) {
}
