package com.blue.water.mapper;

import com.blue.water.dto.response.FriendshipResponse;
import com.blue.water.model.FriendRequest;
import com.blue.water.model.Friendship;
import org.mapstruct.Builder;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface FriendshipMapper {

    Friendship toFriendShip(FriendRequest friendRequest);

    FriendshipResponse toResponse(Friendship friendship);

}
