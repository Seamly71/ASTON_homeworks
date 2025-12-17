package ru.seamly71.ASTON_homeworks.sprint1;

import java.lang.reflect.Field;

public class Demo {

    public static void main(String[] args) {
        System.out.println(
            String.format("Testing mutability: %b", testMutability())
        );
        System.out.println(
            String.format("Testing immutability: %b", testImmutability())
        );
    }

    private static boolean testMutability() {
        MutableIntWrapper first = new MutableIntWrapper(1);
        MutableIntWrapper second = first;
        second.setNumber(2);
        return first == second;
    }

    private static boolean testImmutability() {
        ImmutableWithMutableField immutableObject =
                new ImmutableWithMutableField(
                        new MutableIntWrapper(2)
                );
        MutableIntWrapper fromGetter = immutableObject.getMutableField();
        try {
            Field mutableField = immutableObject.getClass().getDeclaredField("mutableField");
            mutableField.setAccessible(true);
            Object formReflection = mutableField.get(immutableObject);
            return formReflection != fromGetter;
        }
        catch (NoSuchFieldException|IllegalAccessException _){
            return false;
        }
    }
}
