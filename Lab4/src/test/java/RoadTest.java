import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    void getCountOfHumans() {
        Person person1 = new Person("Person1",23);
        Policeman policeman1 = new Policeman("Policemen1",24);
        Fireman fireman1 = new Fireman("Fireman1",25);
        Person person2 = new Person("Person2",23);
        Policeman policeman2 = new Policeman("Policemen2",24);
        Fireman fireman2 = new Fireman("Fireman2",25);
        Person person3 = new Person("Person3",23);
        Policeman policeman3 = new Policeman("Policemen3",24);
        Fireman fireman3 = new Fireman("Fireman3",25);
        Road road = new Road();
        FireCar fireCar = new FireCar(4);
        fireCar.addPassenger(fireman1);
        fireCar.addPassenger(fireman2);
        PoliceCar policeCar = new PoliceCar(6);
        policeCar.addPassenger(policeman1);
        policeCar.addPassenger(policeman2);
        Taxi taxi = new Taxi(4);
        taxi.addPassenger(person1);
        taxi.addPassenger(policeman3);
        Bus bus = new Bus(10);
        bus.addPassenger(person2);
        bus.addPassenger(person3);
        bus.addPassenger(fireman3);
        road.carsInRoad.add(fireCar);
        road.carsInRoad.add(policeCar);
        road.carsInRoad.add(taxi);
        road.carsInRoad.add(bus);
        int expected = 9;
        assertEquals(expected,road.getCountOfHumans());
    }

    @Test
    void addCarToRoad() {
        Road road = new Road();
        Person person1 = new Person("Person1",23);
        Policeman policeman1 = new Policeman("Policemen1",24);
        Fireman fireman1 = new Fireman("Fireman1",25);
        Bus bus = new Bus(10);
        bus.addPassenger(person1);
        bus.addPassenger(fireman1);
        bus.addPassenger(policeman1);
        road.carsInRoad.add(bus);
        Set<Vehicle> expected = Set.of(bus);
        assertEquals(expected,road.carsInRoad);
    }
}