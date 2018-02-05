package org.java.practice.java.lang;

import java.util.stream.IntStream;

public class Numbers {

    public static void main(String[] args) {

        IntStream.iterate(1, i -> i < 17, i -> i+1).forEach(i-> System.out.print(Double.toHexString(i)+" "));
        System.out.println();
        Double val = 3.14;
        System.out.println("isNaN? "+val.isNaN());
        System.out.println("isInfinite？ "+val.isInfinite());
        System.out.println("compareTo(-3.14)？ "+val.compareTo(-3.14));
        System.out.println(val.hashCode());
        System.out.println(val.intValue());
        System.out.println(val.byteValue());

        Long longVal = 178423917429431492L;
        System.out.println("toString "+longVal.toString());
        System.out.println("byteValue "+longVal.byteValue());
        System.out.println("hashCode "+longVal.hashCode());
        System.out.println("intValue "+longVal.intValue());
        System.out.println("shortValue "+longVal.shortValue());

        System.out.println("Byte.decode(\"illidan·stormrage\") "+Byte.decode("123"));

        Integer intVal = 100;
        System.out.println("intVal.byteValue() "+intVal.byteValue());

        Float floatVal = (float) 3.14;
        System.out.println("floatToIntBits "+Float.floatToIntBits((float) 3.14));
        System.out.println("floatToRawIntBits "+Float.floatToRawIntBits((float) 3.14));

        System.out.println("compareUnsigned "+Short.compareUnsigned((short) -1, (short) 0));
        System.out.println(Short.toUnsignedInt((short) -1));
        System.out.println(Short.reverseBytes((short) 1));
    }
}
