package com.ashhh.user.service.External.Service;


import com.ashhh.user.service.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotel/{HotelId}")
    Hotel getHotel(@PathVariable String HotelId);
}
