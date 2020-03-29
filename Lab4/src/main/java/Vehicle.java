import java.util.HashSet;
import java.util.Set;

public abstract class Vehicle {
    private Set<Person> passengers = new HashSet<>();

    private int seats;

    protected Vehicle(int seats) {
        if(seats<0){
            throw new LessThenZeroSeatsExeption("Seats can not be less then 0");
        }
        this.seats = seats;
    }

    protected int maxPlaces() {
        return seats;
    }

    public Set<Person> getPassengers() {
        return passengers;
    }

    public void addPassenger(Person person){
        if (passengers.size() == maxPlaces()) {
            throw new NoPlaceExeption("Can not place more people then seats");
        }

        if (person.seat == true) {
            throw new AlreadyPassengerExeption("Can not place person which already passenger");
        }

        person.seat = true;
        passengers.add(person);
    }

    public int occupiedPlaces() {
        return passengers.size();
    }

    public void getOffPerson(Person person) throws NoPassengerExeption {
        if (!(passengers.contains(person))) {
            throw new NoPassengerExeption("This person not passenger");
        }
        passengers.remove(person);
    }
}
