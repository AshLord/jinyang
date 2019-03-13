package org.java.enterprise.spring_design_pattern;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author jinyang
 * @date 2019/3/13 0013.
 */
@Component
@Order(1)
public class FirstCheck implements Check {

    @Override
    public boolean ok() {
        return true;
    }

}
