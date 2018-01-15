package org.java.practice.jdk8;

import java.math.BigDecimal;

/**
 * @author yang.jin
 * date: 15/01/2018
 * desc: jdk8特性 接口默认方法
 */
public interface DefaultIntefaceMethod {

    default int hashcode() {
        return this.hashCode() * 2;
    }

    default BigDecimal parseYuan(String val) {
        return string2BigDecimal(val).multiply(new BigDecimal(100));
    }

    default BigDecimal string2BigDecimal(String val) {
        if (!val.matches("^[0-9]*$")) {
            throw new UnsupportedOperationException();
        }
        return new BigDecimal(val);
    }
}
