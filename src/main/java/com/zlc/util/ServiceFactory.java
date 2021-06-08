package com.zlc.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 邹陆川
 * @Date: 2021/06/04/6:15 下午
 * @Description:
 */
public class ServiceFactory {
    //传递A对象，得到B对象的过程
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
