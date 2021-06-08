package com.zlc.test;

import com.zlc.domain.User;
import com.zlc.service.UserService;
import com.zlc.service.impl.UserServiceImpl;
import com.zlc.util.ServiceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 邹陆川
 * @Date: 2021/06/04/4:57 下午
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
       /* String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        List<User>  users = session.selectList("testNamespace.getAll");
        for(User user:users){
            System.out.println(user);
        }
        session.close();*/


        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImpl());
       // List<User> users = userService.getAllByContent("是个");

        //模糊查询
     /*   User user = new User();
        user.setName("z");
        user.setContent("是");
        List<User> users = userService.getAllByLike(user);*/

        //foreach 遍历查询
       // String[] array = {"1","6d12585d24014662b71d0f9a1639dcfd"};
       // List<User> users = userService.getAllByArray(array);

       // for(User user1:users){
       //   System.out.println(user1);
       // }

        //多表查询
        System.out.println("test01的GitHub操作12345");
        List<Map<String,Object>> users = userService.getAllBys();
        for (Map<String,Object> maps:users
             ) {
            Set<String> set = maps.keySet();
            for(String s:set){
                System.out.println("key:"+s);
                System.out.println("value:"+maps.get(s));
            }
            System.out.println("---------------------------------");
        }

        //UserService userService = new UserServiceImpl();
        //User user =  userService.getUserById(1);
        //System.out.println(user);
//       List<User> users = userService.getAll();
//       for(User user:users){
//           System.out.println(user);
//       }
//        User user = new User();
//        user.setId(getUid());
//        user.setName("刘亦菲");
//        user.setContent("刘亦菲姐姐是个大美女");
//        user.setState("1");
//        user.setPhone("15281853732");
//        userService.addUser(user);
//        user.setContent("韩非子是个高人");
//        user.setId("1");
//        userService.updUser(user);


    }

    //生成全球唯一ID
    private static String getUid() {
        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString();
        //去掉字符串中的-
        uid = uid.replaceAll("-","");
        return uid;
    }

}
