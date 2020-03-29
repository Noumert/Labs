import java.util.HashSet;
import java.util.Set;

public class PoliceCar extends Car {
    public PoliceCar(int seats) {
        super(seats);
    }

    public void addPassenger(Person person) {
        if (!(person instanceof Policeman)) {
            person.seat = false;
            throw new WrongPassengerExeption("Can not place not policeman");
        }
        super.addPassenger(person);
    }
}
