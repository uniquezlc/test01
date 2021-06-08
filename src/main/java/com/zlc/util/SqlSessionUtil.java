package com.zlc.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 邹陆川
 * @Date: 2021/06/04/5:35 下午
 * @Description:
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    //私有化构造方法，防止后面创建此类，耗费内存
    private SqlSessionUtil(){}
    //使用静态语句块来创建输入流和SqlSessionFactory
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //本地线程变量，用于事务控制，为每一个进程创建一个SqlSession对象
    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();

    //取得session对象
    public static SqlSession getSession(){
        SqlSession session = t.get();
        //若为空则创建
        if (session==null){
            session = sqlSessionFactory.openSession();
            //将这个session存到池中
            t.set(session);
        }
        return session;
    }

    //关闭session
    public static void myClose(SqlSession session){
        if(session != null){
            //关闭
            session.close();
            //在线程池中抹去当前数据
            t.remove();
        }
    }
}
