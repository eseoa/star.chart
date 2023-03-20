package com.blue.water.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "users")
@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "email")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "users_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private Long id;

    private UUID externalId;

    private String email;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Image> images = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FriendRequest> friendRequests = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Friendship> friendships = new HashSet<>();

    public void addImage(Image image) {
        images.add(image);
        image.setUser(this);
    }

    public void removeImage(Image image) {
        images.remove(image);
    }

    public void addFriendship(Image image) {
        images.add(image);
        image.setUser(this);
    }

    public void removeFriendShip(Friendship friendship) {
        friendships.remove(friendship);
    }

    public void addFriendRequest(FriendRequest friendRequest) {
        friendRequests.add(friendRequest);
        friendRequest.setUser(this);
    }

    public void removeFriendRequest(FriendRequest friendRequest) {
        friendRequests.remove(friendRequest);
    }

    public void removeAllImages() {
        images.clear();
    }
}