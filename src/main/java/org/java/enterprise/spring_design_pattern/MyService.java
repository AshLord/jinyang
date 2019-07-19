package org.java.enterprise.spring_design_pattern;

import org.java.practice.design.pattern.behavior.twoclass.iterator.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 用Spring实现？？？
 *
 * @author jinyang
 * @date 2019/3/13 0013.
 */
@Service
public class MyService {

    @Autowired
    private List<Check> checks;

    public void myFunction() {

        checks.sort((o1, o2) -> {
            Order order1 = o1.getClass().getAnnotation(Order.class);
            Order order2 = o2.getClass().getAnnotation(Order.class);
            return order1.value() - order2.value();
        });
        boolean ok = true;
        for (Check check : checks) {
            if (!check.ok()) {
                ok = false;
            }
        }
        if (!ok) {
            System.out.println("流程终止");
            return;
        }

        System.out.println("流程继续");
    }

}
