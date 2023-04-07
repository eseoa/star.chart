package com.blue.water.service;

import com.blue.water.dto.request.ImageRequest;
import com.blue.water.mapper.ImageMapper;
import com.blue.water.model.Image;
import com.blue.water.model.User;
import com.blue.water.repository.ImageRepository;
import com.blue.water.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    ImageRepository imageRepository;
    UserRepository userRepository;
    ImageMapper imageMapper;

    public void add(Long userId, ImageRequest imageRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User was not found"));

        Image image = imageMapper.toImage(imageRequest);

        if(image.isMain()) {
            imageRepository.setMainToFalseByUserId(userId);
        }

        imageRepository.save(image);
        user.addImage(image);
    }


    public void deleteByUrl(String url) {
        Image image = imageRepository.findByUrl(url)
                .orElseThrow(() -> new EntityNotFoundException("Image was not found"));

        if(!image.isMain()) {
            imageRepository.deleteByUrl(url);
            return;
        }

        User user = image.getUser();
        user.removeImage(image);
        user.getImages().get(0).setMain(true);
    }

    public void changeMainImage(String url) {
        Image image = imageRepository.findByUrl(url)
                .orElseThrow(() -> new EntityNotFoundException("Image was not found"));

        if(image.isMain()) {
            return;
        }
        User user = image.getUser();
        imageRepository.setMainToFalseByUserId(user.getId());
        image.setMain(true);
    }
}
