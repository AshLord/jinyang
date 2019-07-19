package org.java.enterprise.rule_engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author jinyang
 * @date 2019/5/28 0028.
 */
@Service
public class Main {

    @Autowired
    private ValidChains validChains;

    public void myBizLogic1() {
        Context context = new Context();
        validChains.check(context, ValidChains.CHAINS_2);
        if (!"SUCCESS".equals(context.getResult())) {
            return;
        }
        System.out.println("do other biz logic");
    }

    public void myBizLogic2() {
        Context context = new Context();
        validChains.check(context, ValidChains.CHAINS_1);
        if (!"SUCCESS".equals(context.getResult())) {
            return;
        }
        System.out.println("do other biz logic");
    }
}
