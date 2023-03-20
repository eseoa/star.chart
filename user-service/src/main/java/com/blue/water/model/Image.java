package com.blue.water.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "images")
@EqualsAndHashCode(of = "url")
public class Image {

    @Id
    @SequenceGenerator(name = "images_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_sequence")
    private Long id;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private Long fromUserId;


}
