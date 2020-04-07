public class Car<T extends Person> extends Vehicle<T> {
    protected Car(int seats) {
        super(seats);
    }
}
