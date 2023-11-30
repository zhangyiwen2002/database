package com.example.bedemo.getBean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //将容器中的bean赋值给context,为了static赋值
        this.context = applicationContext;
    }

    /**
     * 根据指定的名字获取bean对象
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return context.getBean(name);
    }

    //通过class获取
    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        return context.getBean(requiredType);
    }
}
