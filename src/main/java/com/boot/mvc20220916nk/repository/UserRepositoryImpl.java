package com.boot.mvc20220916nk.repository;

import com.boot.mvc20220916nk.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("a") // @Component // 이 클래스를 이름 a로 IoC에 저장을 하라~
public class UserRepositoryImpl implements UserRepository{ // ctrl + I 로 implements methods

    private final List<User> userData;

    public UserRepositoryImpl() { // 생성자  alt insert
        userData = new ArrayList<User>();

        for(int i = 0; i < 5; i++) {
            int index = i + 1;

            User user = User.builder()
                    .user_code(index)
                    .user_id("user" + index)
                    .user_name("1111")
                    .user_password("user" + index)
                    .user_email("user" + index + "@")
                    .build();

            userData.add(user);
        }

    }

    @Override
    public int save(User user) {
        try {
            int maxCode = 0;
            for(User u : userData){
                if(u.getUser_code() > maxCode) {
                    maxCode = u.getUser_code();
                }
            }
            maxCode++;

            user.setUser_code(maxCode);

            userData.add(user);
        }catch (Exception e) {
            return 0;
        }
        return 1;
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
    public int remove(int userCode) {
        return 0;
    }
}
