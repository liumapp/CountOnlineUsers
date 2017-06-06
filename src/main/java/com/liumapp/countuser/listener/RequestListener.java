package com.liumapp.countuser.listener;


import com.liumapp.countuser.entity.User;
import com.liumapp.countuser.util.SessionManager;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liumapp on 6/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@WebListener
public class RequestListener implements ServletRequestListener{

    private List<User> userList;

    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        if (userList == null)
            userList = new ArrayList<User>();

        HttpServletRequest request = (HttpServletRequest)servletRequestEvent.getServletRequest();
        String sessionId = request.getSession().getId();
        String lastLoginTime = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date());

        if (SessionManager.hasUserBySessionId(userList , sessionId)) {
            //用户已经存在
            SessionManager.getUserBySessionId(userList , sessionId).setLastLoginTime(lastLoginTime);

        } else {
            //用户不在userlist中
            User user = new User();
            user.setIp(request.getRemoteAddr());
            user.setLastLoginTime(lastLoginTime);
            user.setSessionId(sessionId);

            userList.add(user);

        }

        request.getServletContext().setAttribute("userList" , userList);

    }

}
