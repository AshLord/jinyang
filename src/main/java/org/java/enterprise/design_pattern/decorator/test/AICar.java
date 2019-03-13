package org.java.enterprise.design_pattern.decorator.test;
//ConcreteDecorator具体装饰角色
class AICar extends SuperCar {
	
	public AICar(ICar car) {
		super(car);
	}
	
	public void autoMove(){
		System.out.println("自动跑！");
	}
	
	@Override
	public void move() {
		super.move();
		autoMove();
	}
	
}