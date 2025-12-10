package sprint1;

import java.lang.reflect.Field;

public class Test {

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
        ImmutableWithMutableField immutable_object = new ImmutableWithMutableField(2);
        MutableIntWrapper from_getter = immutable_object.getMutableField();
        try {
            Field mutable_field = immutable_object.getClass().getDeclaredField("mutable_field");
            mutable_field.setAccessible(true);
            Object form_reflection = mutable_field.get(immutable_object);
            return form_reflection != from_getter;
        }
        catch (NoSuchFieldException|IllegalAccessException _){
            return false;
        }
    }
}
