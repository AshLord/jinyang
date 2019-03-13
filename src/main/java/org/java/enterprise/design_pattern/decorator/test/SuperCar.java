package org.java.enterprise.design_pattern.decorator.test;
//Decorator装饰角色
class SuperCar implements ICar {
	protected ICar car;
	public SuperCar(ICar car) {
		super();
		this.car = car;
	}

	@Override
	public void move() {
		car.move();
	}
}