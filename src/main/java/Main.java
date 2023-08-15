import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> collectionFlights = FlightBuilder.createFlights();
        Filter departureFilter = new DepartureDateFilter();
        Filter durationFilter = new DurationFilter();
        Filter arrivalFilter = new ArrivalDateFilter();
        Filters filters = new Filters(departureFilter, durationFilter, arrivalFilter);
        List<Flight> filteredFlights = filters.filter(collectionFlights, departureFilter);
        System.out.println(filteredFlights);
    }
}
