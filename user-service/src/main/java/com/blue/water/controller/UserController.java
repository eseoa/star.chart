package com.blue.water.controller;

import com.blue.water.StringLiterals;
import com.blue.water.dto.request.UserCreateRequest;
import com.blue.water.dto.request.UserUpdateRequest;
import com.blue.water.dto.response.ErrorResponse;
import com.blue.water.dto.response.UserResponse;
import com.blue.water.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "API for working with the User entity")
@ApiResponses({
        @ApiResponse(
                     responseCode = "400",
                     description = "Incorrect data was transmitted to the server",
                     content = @Content(
                                        mediaType = StringLiterals.MediaTypes.APPLICATION_JSON,
                                        schema = @Schema(implementation = ErrorResponse.class)
                     )
        ),
        @ApiResponse(
                     responseCode = "404",
                     description = "User not found",
                     content = @Content(
                                   mediaType = "MEDIA_TYPE_APP_JSON",
                                   schema = @Schema(implementation = ErrorResponse.class)
                )
        )}
)
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(operationId = "createUser", summary = "Creating a new user")
    @ApiResponse(
                 responseCode = StringLiterals.ResponseCodes.CREATED,
                 description = "The user has been successfully created",
                 content = @Content(mediaType = StringLiterals.MediaTypes.APPLICATION_JSON)
    )
    public Long create(
                       @RequestBody
                       @Parameter(name = "UserCreateRequest", description = "User information")
                       UserCreateRequest userCreateRequest
    ) {
        return userService.create(userCreateRequest);
    };

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(operationId = "getUserById", summary = "Getting a user by id")
    @ApiResponse(
                 responseCode = StringLiterals.ResponseCodes.CREATED,
                 description = "The user has been successfully received",
                 content = @Content(mediaType = StringLiterals.MediaTypes.APPLICATION_JSON)
    )
    public UserResponse getById(
                                @PathVariable
                                @Parameter(name = "User id", description = "User's unique identifier")
                                Long id
    ) {
        return userService.getById(id);
    };

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(operationId = "updateUserById", summary = "Updating a user by id")
    @ApiResponse(
                 responseCode = StringLiterals.ResponseCodes.CREATED,
                 description = "The user has been successfully updated",
                 content = @Content(mediaType = StringLiterals.MediaTypes.APPLICATION_JSON)
    )
    public UserResponse updateById(
                                   @PathVariable
                                   @Parameter(name = "UserId", description = "User's unique identifier")
                                   Long id,
                                   @RequestBody
                                   @Parameter(name = "UserUpdateRequest", description = "User information")
                                   UserUpdateRequest userUpdateRequest
    ) {
        return userService.updateById(id, userUpdateRequest);
    };

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(operationId = "deleteUserById", summary = "Deleting a user by id")
    @ApiResponse(
                 responseCode = StringLiterals.ResponseCodes.CREATED,
                 description = "The user has been successfully deleted",
                 content = @Content(mediaType = StringLiterals.MediaTypes.APPLICATION_JSON)
    )
    public void deleteById(
                           @PathVariable
                           @Parameter(name = "UserId", description = "User's unique identifier")
                           Long id
    ) {
        userService.deleteById(id);
    };


}
