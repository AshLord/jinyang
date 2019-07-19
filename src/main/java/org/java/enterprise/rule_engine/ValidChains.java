package org.java.enterprise.rule_engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author jinyang
 * @date 2019/5/28 0028.
 */
@Component
public class ValidChains {

    public static final List<Class> CHAINS_1 = Arrays.asList(
            Validator1.class,
            Validator2.class
    );

    public static final List<Class> CHAINS_2 = Arrays.asList(
            Validator1.class,
            Validator3.class
    );

    private final Map<String, IValidator> validatorMap;

    @Autowired
    public ValidChains(Map<String, IValidator> validatorMap) {
        this.validatorMap = validatorMap;
    }

    public void check(Context context, List<Class> chains) {
        for (Class validClz : chains) {
            IValidator validator = validatorMap.get(validClz.getSimpleName());
            validator.check(context);
            if (!"SUCCESS".equals(context.getResult())) {
                 break;
            }
        }
    }

}
