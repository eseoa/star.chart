package com.blue.water.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "friend_requests")
@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequest {

    @Id
    @SequenceGenerator(name = "friend_requests_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friend_requests_sequence")
    private Long id;

    @Enumerated(EnumType.STRING)
    private FriendRequestStatus friendRequestStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
