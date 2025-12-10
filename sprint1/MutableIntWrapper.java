package sprint1;

public class MutableIntWrapper {

    private int number;

    public MutableIntWrapper(final int number) {
        this.number = number;
    }

    public MutableIntWrapper(final MutableIntWrapper another) {
        this.number = another.getNumber();
    }

    public MutableIntWrapper setNumber(final int number) {
        this.number = number;
        return this;
    }

    public int getNumber() {
        return this.number;
    }
}
