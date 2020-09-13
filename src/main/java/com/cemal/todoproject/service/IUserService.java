package com.cemal.todoproject.service;

import com.cemal.todoproject.entity.User;

public interface IUserService {
    User addUser();
    User getUserById();
    User updateUser();
    Boolean deleteUser();
}
