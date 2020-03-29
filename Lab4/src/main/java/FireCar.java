import java.util.HashSet;
import java.util.Set;

public class FireCar extends Car {
    public FireCar(int seats) {
        super(seats);
    }

    public void addPassenger(Person person) {
        if (!(person instanceof Fireman)) {
            person.seat = false;
            throw new WrongPassengerExeption("Can not place not fireman");
        }
        super.addPassenger(person);
    }
}
