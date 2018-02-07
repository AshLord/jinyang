package org.java.practice.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.context.ContextLoader;

/**
 * @author yang.jin
 * date: 07/02/2018
 * desc:
 */
public class ApplicationContextDemo {

    public static void main(String[] args) {
        //主角 对Web应用的支持
        ApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();

        //继承实现  国际化
        MessageSource messageSource;

        //继承实现  强大的事件机制
        ApplicationEventPublisher applicationEventPublisher;

        //继承实现  底层资源的访问
        ResourcePatternResolver resourcePatternResolver;

        /**
         * .BeanFactroy采用的是延迟加载形式来注入Bean的，即只有在使用到某个Bean时(调用getBean())，才对该Bean进行加载实例化，这样，我们就不能发现一些存在的spring的配置问题。而ApplicationContext则相反，它是在容器启动时，一次性创建了所有的Bean。这样，在容器启动时，我们就可以发现Spring中存在的配置错误。
         */

        /**
         * BeanFactory和ApplicationContext都支持BeanPostProcessor、BeanFactoryPostProcessor的使用，但两者之间的区别是：BeanFactory需要手动注册，而ApplicationContext则是自动注册
         */

        {
            //1.ApplicationContext发送该事件时，表示该容器中所有的Bean都已经被装载完成，此ApplicationContext已就绪可用
            ContextRefreshedEvent contextRefreshedEvent;

            //2.生命周期 beans的启动信号
            ContextStartedEvent contextStartedEvent;

            //3.生命周期 beans的停止信号
            ContextStoppedEvent contextStoppedEvent;

            //4.ApplicationContext关闭事件，则context不能刷新和重启，从而所有的singleton bean全部销毁(因为singleton bean是存在容器缓存中的)
            ContextClosedEvent contextClosedEvent;
        }

    }
}
