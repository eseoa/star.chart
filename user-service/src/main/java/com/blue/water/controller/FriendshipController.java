package com.blue.water.controller;

import com.blue.water.dto.request.FriendshipRequest;
import com.blue.water.service.FriendshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("public/api/v1/users/{userId}/friendships")
@RequiredArgsConstructor
public class FriendshipController {

    FriendshipService friendshipService;

    @PostMapping
    public Long create(@PathVariable Long userId, @RequestBody FriendshipRequest friendshipRequest) {
        return friendshipService.create(userId, friendshipRequest);
    }

    @DeleteMapping("id")
    public void delete(@PathVariable Long userId) {
        return friendshipService.delete(userId);
    }




}
