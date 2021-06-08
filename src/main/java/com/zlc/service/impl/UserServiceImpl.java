package com.zlc.service.impl;

import com.zlc.dao.UserDao;
import com.zlc.domain.User;
import com.zlc.service.UserService;
import com.zlc.util.SqlSessionUtil;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 邹陆川
 * @Date: 2021/06/05/9:19 上午
 * @Description:
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = SqlSessionUtil.getSession().getMapper(UserDao.class);
    @Override
    public User getUserById(Integer id) {
        User user = userDao.getUserById(id);
        return user;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updUser(User user) {
        userDao.updUser(user);
    }

    @Override
    public List<User> getAll() {
      return   userDao.getAll();
    }

    @Override
    public List<User> getAllByContent(String string) {
        return userDao.getAllByContent(string);
    }

    @Override
    public List<User> getAllByLike(User user) {
        return userDao.getAllByLike(user);
    }

    @Override
    public List<User> getAllByArray(String[] array) {
        return userDao.getAllByArray(array);
    }

    @Override
    public List<Map<String, Object>> getAllBys() {
        return userDao.getAllBys();
    }
}
