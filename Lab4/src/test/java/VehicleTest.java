import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void addPassengerAlreadyPassenger() {
        Person person = new Person("Jack", 23);
        Bus bus = new Bus(5);
        assertThrows(AlreadyPassengerExeption.class, () -> {
            bus.addPassenger(person);
            bus.addPassenger(person);
        });
    }

    @Test
    void LessThenZeroSeats() {
        assertThrows(LessThenZeroSeatsExeption.class, () -> {
            Bus bus = new Bus(-8);
        });
    }

    @Test
    void maxPlacesTest() {
        Bus bus =new Bus(4);
        int expected = 4;
        assertEquals(expected,bus.maxPlaces());
    }

    @Test
    void occupiedPlacesTest() {
        Person person = new Person("Jack", 23);
        Fireman fireman = new Fireman("Heck", 25);
        Bus bus = new Bus(3);
        bus.addPassenger(person);
        bus.addPassenger(fireman);
        int expected = 2;
        assertEquals(expected,bus.occupiedPlaces());
    }

    @Test
    void addPassengerSuccess() {
        Person person = new Person("Jack", 23);
        Fireman fireman = new Fireman("Heck", 25);
        Bus bus = new Bus(3);
        bus.addPassenger(person);
        bus.addPassenger(fireman);
        Set<Person> expected = Set.of(person, fireman);
        assertEquals(expected, bus.getPassengers());
    }

    @Test
    void getOffPassengerSuccess() {
        Person person = new Person("Jack", 23);
        Fireman fireman = new Fireman("Heck", 25);
        Policeman policeman = new Policeman("Joe", 32);
        Bus bus = new Bus(5);
        bus.addPassenger(person);
        bus.addPassenger(fireman);
        bus.addPassenger(policeman);
        bus.getOffPerson(policeman);
        Set<Person> expected = Set.of(person, fireman);
        assertEquals(expected, bus.getPassengers());
    }

    @Test
    void addPassengerNoPlace() {
        Person person = new Person("Jack", 23);
        Fireman fireman = new Fireman("Heck", 25);
        Bus bus = new Bus(1);
        assertThrows(NoPlaceExeption.class, () -> {
            bus.addPassenger(person);
            bus.addPassenger(fireman);
        });
    }

    @Test
    void getOffPassengerNoPassenger() {
        Person person = new Person("Jack", 23);
        Bus bus = new Bus(5);
        assertThrows(NoPassengerExeption.class, () -> {
            bus.getOffPerson(person);
        });
    }
}