package com.blue.water.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

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

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FriendRequest> friendRequests = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Friendship> friendships = new ArrayList<>();

    public void addImage(Image image) {
        images.add(image);
        image.setUser(this);
    }

    public void removeImage(Image image) {
        images.remove(image);
    }

    public void addFriendship(Friendship friendship) {
        friendships.add(friendship);
        friendship.setUser(this);
    }

    public void removeFriendship(Friendship friendship) {
        friendships.remove(friendship);
    }

    public void addFriendRequest(FriendRequest friendRequest) {
        friendRequests.add(friendRequest);
        friendRequest.setUser(this);
    }

    public void removeFriendRequest(FriendRequest friendRequest) {
        friendRequests.remove(friendRequest);
    }
}