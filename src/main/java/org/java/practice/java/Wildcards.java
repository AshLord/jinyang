package org.java.practice.java;

public class Wildcards {

    public static void main(String[] args) {

        // cannot compile
        //Plate<Fruit> p=new Plate<Apple>(new Apple());

        /**
         * <? extends T>：是指 “上界通配符（Upper Bounds Wildcards）
         * 上界<? extends T>不能往里存，只能往外取
         */
        Plate<? extends Fruit> p1=new Plate<>(new Apple());
        //p1.setItem(new Fruit());

        /**
         * <? super T>：是指 “下界通配符（Lower Bounds Wildcards）
         * 能往里存，但是不能往外取，因为获得的也是capture类型
         */
        Plate<? super Fruit> p2=new Plate<>(new Apple());
        p2.setItem(new Apple());
        //Apple apple = p2.getItem();

        /**
         * <?> 普通通配符
         * 和上界一样，都是不能存的，需要的都是capture类型
         */
        Plate<?> p3 =new Plate<>(new Apple());
        //p3.setItem(new Apple());

        /**
         * 总结：PECS原则 （Producer Extends Consumer Super）
         * 频繁往外读取内容的，适合用上界Extends。
           经常往里插入的，适合用下界Super
         */
    }

    public static class Fruit {

    }

    public static class Apple extends Fruit {

    }

    public static class Plate<T> {
        private T item;

        private Plate(T t) {
            this.item = t;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }
}
