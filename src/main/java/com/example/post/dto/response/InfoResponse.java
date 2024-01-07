package com.example.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InfoResponse {
    private String id;
    private String role;
    private String name;
    private String email;
}
