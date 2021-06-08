package com.zlc.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 邹陆川
 * @Date: 2021/06/04/6:01 下午
 * @Description:
 */
public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;
    public TransactionInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;
        try {
            session = SqlSessionUtil.getSession();
            //处理业务逻辑
            obj = method.invoke(target,args);
            //提交业务
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(session);
        }
        return obj;
    }

    //获得代理
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

}
