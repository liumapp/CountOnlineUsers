package com.liumapp.countuser.listener;

import com.liumapp.countuser.entity.User;
import com.liumapp.countuser.util.SessionManager;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liumapp on 6/5/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@WebListener
public class SessionManagerListener implements HttpSessionListener {

    private int userNumber = 0 ;

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        userNumber++;
        httpSessionEvent.getSession().getServletContext().setAttribute("currentUser" , userNumber);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        userNumber--;
        httpSessionEvent.getSession().getServletContext().setAttribute("currentUser" , userNumber);

        ArrayList<User> userList = null;

        userList =  (ArrayList<User>)httpSessionEvent.getSession().getServletContext().getAttribute("userList");

        if (SessionManager.hasUserBySessionId(userList , httpSessionEvent.getSession().getId())) {
            userList.remove(SessionManager.getUserBySessionId(userList , httpSessionEvent.getSession().getId()));
        }

    }

}
