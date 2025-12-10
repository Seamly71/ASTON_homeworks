package sprint1;

public class ImmutableWithMutableField {

    private final MutableIntWrapper mutable_field;

    public ImmutableWithMutableField(final int number) {
        this.mutable_field = new MutableIntWrapper(number);
    }

    public MutableIntWrapper getMutableField(){
        return new MutableIntWrapper(this.mutable_field);
    }
}
