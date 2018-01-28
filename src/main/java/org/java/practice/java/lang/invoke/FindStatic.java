package org.java.practice.java.lang.invoke;

        import java.lang.invoke.MethodHandle;
        import java.lang.invoke.MethodHandles;
        import java.lang.invoke.MethodType;
        import java.util.Arrays;
        import java.util.List;

public class FindStatic {

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findStatic(FindStatic.class, "doubleVal", MethodType.methodType(int.class, int.class));
        List<Integer> dataList = Arrays.asList(1, 2, 3, 4, 5);
        for (int i = 0; i < dataList.size(); i++) {
            dataList.set(i, (Integer) mh.invoke(dataList.get(i)));//invoke
        }
        for (Integer data : dataList) {
            System.out.println(data);//2,4,6,8,10
        }
    }

    public static int doubleVal(int val) {
        return val * 2;
    }
}