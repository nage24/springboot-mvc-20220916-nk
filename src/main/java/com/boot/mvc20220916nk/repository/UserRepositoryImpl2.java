package com.boot.mvc20220916nk.repository;

import com.boot.mvc20220916nk.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// @Component("b")
@Repository("b") // 이 클래스를 이름 b로 IoC에 저장을 하라~
public class UserRepositoryImpl2 implements UserRepository{ // ctrl + I 로 implements methods

    @Qualifier
    @Autowired // 무조건 같이 쓴디야
    private final List<User> userData;

    public UserRepositoryImpl2() { // 생성자  alt insert
        userData = new ArrayList<User>();

        for(int i = 0; i < 9; i++) {
            int index = i + 1;

            User user = User.builder()
                    .user_code(index)
                    .user_id("ng9")
                    .user_name("1111")
                    .user_password("갱나")
                    .user_email("ng9@")
                    .build();

            userData.add(user);
        }
    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public User findUserByUserId(String userId) {
        User user = null;

        for(User userObj: userData) {
            if(userObj.getUser_id().equals("userId")) {
                user = userObj;
            }
        }

        return user;
    }

    @Override
    public User findUserByUserCode(int userCode) {
        User user = null;

        for(User userObj: userData) {
            if(userObj.getUser_code() == userCode) {
                user = userObj;
            }
        }

        return user;
    }

    @Override
    public int modify(User user) {
        return 0;
    }

    @Override
    public int remove(String userCode) {
        return 0;
    }
}
