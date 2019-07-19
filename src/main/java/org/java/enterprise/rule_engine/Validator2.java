package org.java.enterprise.rule_engine;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author jinyang
 * @date 2019/5/28 0028.
 */
@Component("Validator2")
public class Validator2 implements IValidator {


    @Override
    public void check(Context context) {
        context.setResult("SUCCESS");
    }
}
