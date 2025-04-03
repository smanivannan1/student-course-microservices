package com.sachin.enrollment.client;

import com.sachin.enrollment.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClientFeign {

    @GetMapping("/api/users/{id}")
    UserDto getUserById(@PathVariable("id") Long userId);
}
