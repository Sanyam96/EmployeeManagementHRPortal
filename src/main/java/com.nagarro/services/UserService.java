package com.nagarro.services;

import com.nagarro.models.User;
import org.springframework.stereotype.Service;

/**
 * @author Sanyam Goel created on 17/9/18
 */
public interface UserService {

    User authenticateUser(String username, String password);

}