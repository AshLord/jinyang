package org.java.practice.design.pattern.createmodel.builder;

/**
 * @author yang.jin
 * date: 14/12/2017
 * desc:
 */
public class Test {

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }
}
