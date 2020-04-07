import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PoliceCarTest {

    @Test
    void addPassengerPoliceMan() {
        PoliceCar policeCar = new PoliceCar(4);
        Policeman policeman1 = new Policeman("Vlad",43);
        Policeman policeman2 = new Policeman("Sasha",22);
        policeCar.addPassenger(policeman1);
        policeCar.addPassenger(policeman2);
        Set<Person> expected = Set.of(policeman1,policeman2);
        assertEquals(expected,policeCar.getPassengers());
    }
}