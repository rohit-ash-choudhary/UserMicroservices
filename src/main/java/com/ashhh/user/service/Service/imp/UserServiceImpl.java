package com.ashhh.user.service.Service.imp;

import com.ashhh.user.service.Exception.ResourceNotFoundException;
import com.ashhh.user.service.External.Service.HotelService;
import com.ashhh.user.service.External.Service.RatingService;
import com.ashhh.user.service.Repository.UserRepository;
import com.ashhh.user.service.Service.UserService;
import com.ashhh.user.service.entity.Hotel;
import com.ashhh.user.service.entity.Rating;
import com.ashhh.user.service.entity.User;
import org.apache.juli.logging.LogFactory;
import org.bouncycastle.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userrepository;

    @Autowired
    private HotelService hotelservice;

    @Autowired
    private RatingService ratingservice;

    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate resttemplate;

    @Override
    public User saveUser(User user) {
        String random_user_id= UUID.randomUUID().toString();
        user.setUser_id(random_user_id);
        return userrepository.save(user);
    }

    @Override
    public List<User> getAluser() {
        List<User> userlist=userrepository.findAll();
        List<User> update_list =new ArrayList<>();
        for (User user : userlist) {

            ArrayList<Rating> objects= resttemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUser_id(), ArrayList.class);
            user.setRating(objects);
            System.out.println("{} "+user);
            update_list.add(user);

        }
        return update_list;


    }

    @Override
    public User getUserByID(String user_id) {
      User user=userrepository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User doesn't exists"));
        System.out.println("{------------------}"+user.getUser_id());
            ResponseEntity<Rating> rating_list=ratingservice.getRating(user.getUser_id());
        System.out.println("dddddddddddddddddddd"+rating_list );
       /* ArrayList<Rating> objects= resttemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUser_id(), ArrayList.class);
        System.out.println("{------------------}"+objects);
        user.setRating(objects);*/
        user.setRating(rating_list.getBody());



        return user;

    }

    @Override
    public User updateUser(String user_id) {
        // get the details from the user
        return userrepository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User doesn't exists"));
        //now we need to fetch the rating for this particular use from Rating Service.

    }

    @Override
    public boolean deleteUser(String user_id) {
        return false;
    }
}
