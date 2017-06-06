package com.liumapp.countuser.util;

import com.liumapp.countuser.entity.User;

import java.util.List;

/**
 * Created by liumapp on 6/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class SessionManager {

    public static boolean hasUserBySessionId (List<User> userList , String sessionId) {

        for (int i = 0 ; i < userList.size() ; i++) {
            User user = userList.get(i);
            if (user.getSessionId().equals(sessionId)) {
                return true;
            }
        }

        return false;
    }

    public static User getUserBySessionId (List<User> userList , String sessionId) {

        for (int i = 0 ; i < userList.size() ; i++) {
            User user = userList.get(i);
            if (user.getSessionId().equals(sessionId)) {
                return user;
            }
        }

        return null;
    }

}
