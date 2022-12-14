package com.boot.mvc20220916nk.repository;

import com.boot.mvc20220916nk.domain.User;

public interface UserRepository {
    public int save(User user);
    public User findUserByUserId(String userId);
    public User findUserByUserCode(int userCode);
    public int modify(User user);
    public int remove(int userCode);
}
