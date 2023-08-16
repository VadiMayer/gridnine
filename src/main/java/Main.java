import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> collectionFlights = FlightBuilder.createFlights();
        Filter departureFilter = new ByLongGroundTime(2);
        Filter durationFilter = new ByDepartureDate();
        Filter arrivalFilter = new ByReverseSegments();
        Filters filters = new Filters(departureFilter, durationFilter, arrivalFilter);
        List<Flight> filteredFlights = filters.filter(collectionFlights, departureFilter);
        System.out.println(filteredFlights);
    }
}
