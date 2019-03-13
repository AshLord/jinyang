package org.java.enterprise.design_pattern.strategy.test;

public class Client1 {
	public static void main(String[] args) {
		Strategy strategy = new ConcreteStrategyA();
		Context context = new Context(strategy);
		context.contextInterface();
	}
}
