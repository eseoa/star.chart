package com.blue.water.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema
public record ImageResponse(

        @NotNull
        boolean activeProfilePicture,

        @NotNull
        String url

)
{
}
