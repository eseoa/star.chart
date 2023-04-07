package com.blue.water.controller;

import com.blue.water.StringLiterals;
import com.blue.water.dto.request.UserCreateRequest;
import com.blue.water.dto.request.UserUpdateRequest;
import com.blue.water.dto.response.ErrorResponse;
import com.blue.water.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Интерфейс со swagger аннотациями и необходимыми методами для UserController
 */
@Tag(name = "User")
@ApiResponse(
        responseCode = "400",
        description = "Incorrect data was transmitted to the server",
        content = @Content(
                mediaType = StringLiterals.MediaTypes.APPLICATION_JSON,
                schema = @Schema(implementation = ErrorResponse.class)
        )
)
@ApiResponse(
        responseCode = "404",
        description = "User not found",
        content = @Content(
                mediaType = "MEDIA_TYPE_APP_JSON",
                schema = @Schema(implementation = ErrorResponse.class)
        )

)
public interface UserApi {

    @Operation(operationId = "createUser", summary = "Creating a new user")
    @ApiResponse(
            responseCode = StringLiterals.ResponseCodes.CREATED,
            description = "The user has been successfully created",
            content = @Content(mediaType = StringLiterals.MediaTypes.APPLICATION_JSON)
    )
    public Long create(
            @Parameter(name = "UserCreateRequest", description = "User information")
            UserCreateRequest userCreateRequest
    );

    @Operation(operationId = "updateUserById", summary = "Updating a user by id")
    @ApiResponse(
            responseCode = StringLiterals.ResponseCodes.CREATED,
            description = "The user has been successfully updated",
            content = @Content(mediaType = StringLiterals.MediaTypes.APPLICATION_JSON)
    )
    public UserResponse updateById(
            @Parameter(name = "UserId", description = "User's unique identifier")
            Long id,
            @Parameter(name = "UserUpdateRequest", description = "User information")
            UserUpdateRequest userUpdateRequest
    );

    @Operation(operationId = "getUserById", summary = "Getting a user by id")
    @ApiResponse(
            responseCode = StringLiterals.ResponseCodes.CREATED,
            description = "The user has been successfully received",
            content = @Content(mediaType = StringLiterals.MediaTypes.APPLICATION_JSON)
    )
    public UserResponse getById(
            @Parameter(name = "User id", description = "User's unique identifier")
            Long id
    );

    @Operation(operationId = "deleteUserById", summary = "Deleting a user by id")
    @ApiResponse(
            responseCode = StringLiterals.ResponseCodes.CREATED,
            description = "The user has been successfully deleted",
            content = @Content(mediaType = StringLiterals.MediaTypes.APPLICATION_JSON)
    )
    public void deleteById(
            @Parameter(name = "UserId", description = "User's unique identifier")
            Long id
    );


}
