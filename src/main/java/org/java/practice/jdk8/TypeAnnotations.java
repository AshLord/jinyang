package org.java.practice.jdk8;

/**
 * @author yang.jin
 * date: 16/01/2018
 * desc:
 */
public class TypeAnnotations {

    //使用包装类当容器来存多个注解（老方法）
    @Hints({@Hint("hint1"), @Hint("hint2")})
    class Class1 {}


    public void reflect() {
        Hint hint = AnnotationClass.class.getAnnotation(Hint.class);
        System.out.println(hint);
        // null

        Hints hints1 = AnnotationClass.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);
        // 2
        Hint[] hints2 = AnnotationClass.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);
        // 2
    }

    public static void main(String[] args) {
        TypeAnnotations test = new TypeAnnotations();
        test.reflect();
    }
}
