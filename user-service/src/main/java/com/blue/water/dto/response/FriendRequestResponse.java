package com.blue.water.dto.response;

import com.blue.water.model.FriendRequestStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema
public record FriendRequestResponse(

    @NotNull
    Long id,

    @NotNull
    Long friendId,

    @NotNull
    FriendRequestStatus friendRequestStatus

) {
}
