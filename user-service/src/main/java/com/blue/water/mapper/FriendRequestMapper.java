package com.blue.water.mapper;

import com.blue.water.dto.request.FriendRequestRequest;
import com.blue.water.dto.response.FriendRequestResponse;
import com.blue.water.model.FriendRequest;
import org.mapstruct.Builder;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface FriendRequestMapper {

    FriendRequest toFriendRequest(FriendRequestRequest friendRequestRequest);

    FriendRequestResponse toResponse(FriendRequest friendRequest);

}
