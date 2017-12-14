package org.java.practice.design.pattern.createmodel.builder;

import org.java.practice.design.pattern.createmodel.factorymethod.MailSender;
import org.java.practice.design.pattern.createmodel.factorymethod.Sender;
import org.java.practice.design.pattern.createmodel.factorymethod.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，
 * 用来创建复合对象，所谓复合对象就是指某个类具有不同的属性，其实建造者模式就是前面抽象
 * 工厂模式和最后的Test结合起来得到的。我们看一下代码：
 */
public class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for(int i=0; i<count; i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }
}
