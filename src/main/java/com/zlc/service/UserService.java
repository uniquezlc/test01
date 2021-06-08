package com.zlc.service;

import com.zlc.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 邹陆川
 * @Date: 2021/06/05/9:19 上午
 * @Description:
 */
public interface UserService {
    public User getUserById(Integer id);
    public void addUser(User user);
    public void updUser(User user);

    List<User> getAll();

    List<User> getAllByContent(String string);

    List<User> getAllByLike(User user);

    List<User> getAllByArray(String[] array);

    List<Map<String, Object>> getAllBys();
}
