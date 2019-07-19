package org.java.enterprise.rule_engine;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author jinyang
 * @date 2019/5/28 0028.
 */
@Component("Validator3")
public class Validator3 implements IValidator {


    @Override
    public void check(Context context) {
        context.setResult("SUCCESS");
    }
}
