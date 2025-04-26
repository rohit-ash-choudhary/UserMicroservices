package com.ashhh.user.service.Repository;

import com.ashhh.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    //we can implement here any custom method
}
