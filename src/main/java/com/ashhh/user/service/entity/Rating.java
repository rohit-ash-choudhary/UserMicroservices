package com.ashhh.user.service.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String rating_id;

    private String user_id;

    private String hotel_id;

    private Float rating ;

    private String remark;

}
