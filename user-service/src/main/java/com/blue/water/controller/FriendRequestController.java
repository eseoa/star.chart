package com.blue.water.controller;

import com.blue.water.service.FriendRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("public/api/v1/users/{userId}/friendRequests")
@RequiredArgsConstructor
public class FriendRequestController {

    FriendRequestService friendRequestService;

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long userId, @PathVariable(value = "id") Long friendRequestId) {
        friendRequestService.delete(friendRequestId);
    }

    @PostMapping
    public void delete(@PathVariable Long userId, @PathVariable(value = "id") Long friendRequestId) {
        friendRequestService.delete(friendRequestId);
    }




}
