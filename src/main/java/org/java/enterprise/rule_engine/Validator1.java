package org.java.enterprise.rule_engine;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author jinyang
 * @date 2019/5/28 0028.
 */
@Component("Validator1")
public class Validator1 implements IValidator {


    @Override
    public void check(Context context) {
        context.setResult("SUCCESS");
    }

}
