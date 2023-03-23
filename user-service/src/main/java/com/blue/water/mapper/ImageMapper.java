package com.blue.water.mapper;

import com.blue.water.dto.request.ImageRequest;
import com.blue.water.dto.response.ImageResponse;
import com.blue.water.model.Image;
import org.mapstruct.Builder;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ImageMapper {

    Image toImage(ImageRequest imageRequest);

    ImageResponse toResponse(Image image);

}
