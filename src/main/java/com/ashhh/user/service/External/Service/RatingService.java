package com.ashhh.user.service.External.Service;


import com.ashhh.user.service.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    @GetMapping("/rating/user/{UserId}")
    ResponseEntity<Rating> getRating(@PathVariable String UserId);
}
