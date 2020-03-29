import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FireCarTest {

    @Test
    void addPassengerNoFireMan() {
        PoliceCar policeCar = new PoliceCar(4);
        Person person = new Person("Kevin",9);
        assertThrows(WrongPassengerExeption.class, () -> {
            policeCar.addPassenger(person);
        });
    }

    @Test
    void addPassengerFireMan() {
        FireCar fireCar = new FireCar(4);
        Fireman fireman1 = new Fireman("Vlad",43);
        Fireman fireman2 = new Fireman("Sasha",22);
        fireCar.addPassenger(fireman1);
        fireCar.addPassenger(fireman2);
        Set<Person> expected = Set.of(fireman1,fireman2);
        assertEquals(expected,fireCar.getPassengers());
    }
}