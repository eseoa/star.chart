package com.blue.water.repository;

import com.blue.water.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    void deleteByUrl(String url);

    @Query("""
           UPDATE images as i
           SET
            i.is_main = false
           WHERE
            i.user_id = :userId AND
            i.is_main = true
           """)
    void setMainToFalseByUserId(Long userId);

    Optional<Image> findByUrl(String url);
}
