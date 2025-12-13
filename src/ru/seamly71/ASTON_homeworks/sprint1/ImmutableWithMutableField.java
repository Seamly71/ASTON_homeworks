package ru.seamly71.ASTON_homeworks.sprint1;

public class ImmutableWithMutableField {

    private final MutableIntWrapper mutableField;

    public ImmutableWithMutableField(final MutableIntWrapper mutableField) {
        this.mutableField = new MutableIntWrapper(mutableField);
    }

    public MutableIntWrapper getMutableField(){
        return new MutableIntWrapper(this.mutableField);
    }
}
