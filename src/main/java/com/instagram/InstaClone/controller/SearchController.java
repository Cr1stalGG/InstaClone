package com.instagram.InstaClone.controller;

import com.instagram.InstaClone.dto.UserMainDataDTO;
import com.instagram.InstaClone.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {
    private final UserService userService;

    @GetMapping("/{username}")
    public List<UserMainDataDTO> findAllByUsername(@PathVariable String username){
        return userService.findAllByUsername(username);
    }
}
