import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Road {
    public Set<Vehicle> carsInRoad = new HashSet<>();

    public int getCountOfHumans() {
        int sumPassengers = 0;
        for (Vehicle vehicle :
                carsInRoad) {
            sumPassengers+= vehicle.occupiedPlaces();
        }
        return sumPassengers;
    }

    public void addCarToRoad(Vehicle vehicle) {
        carsInRoad.add(vehicle);
    }
}
