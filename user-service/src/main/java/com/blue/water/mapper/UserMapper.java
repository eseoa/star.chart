package com.blue.water.mapper;

import com.blue.water.dto.request.UserCreateRequest;
import com.blue.water.dto.request.UserUpdateRequest;
import com.blue.water.dto.response.UserResponse;
import com.blue.water.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        builder = @Builder(disableBuilder = true),
        uses = {ImageMapper.class, FriendRequestMapper.class, FriendshipMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    @Mapping(source = "imageRequests", target = "images")
    User toUser(UserCreateRequest userCreateRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User toUser(UserUpdateRequest userUpdateRequest, @MappingTarget User user);

    @Mapping(source = "images", target = "imageResponses")
    @Mapping(source = "friendRequests", target = "friendRequestResponses")
    @Mapping(source = "friendships", target = "friendshipResponses")
    UserResponse toResponse(User user);
}
