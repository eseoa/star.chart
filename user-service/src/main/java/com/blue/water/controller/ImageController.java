package com.blue.water.controller;

import com.blue.water.dto.request.ImageRequest;
import com.blue.water.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("public/api/v1/users/{userId}/images")
@RequiredArgsConstructor
public class ImageController {

    ImageService imageService;

    @DeleteMapping("{url}")
    public void deleteByUrl(@PathVariable Long userId,
                            @PathVariable(value = "id") String url) {
        imageService.deleteByUrl(url);
    }

    @PostMapping
    public void add(@PathVariable Long userId,
                    @RequestBody ImageRequest image) {
        imageService.add(userId, image);
    }

    @PatchMapping("{url}")
    public void changeMainImage(@PathVariable Long userId, @PathVariable String url) {
        imageService.changeMainImage(url);
    }


}
