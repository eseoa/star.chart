package com.blue.water.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "friendships")
@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Friendship {

    @Id
    @SequenceGenerator(name = "friendships_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friendships_sequence")
    private Long id;

    @Enumerated(EnumType.STRING)
    private FriendRequestStatus friendRequestStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
