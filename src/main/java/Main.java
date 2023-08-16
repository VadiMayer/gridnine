import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> collectionFlights = FlightBuilder.createFlights();
        Filter byLongGroundTime = new ByLongGroundTime(2);
        Filter byDepartureDate = new ByDepartureDate();
        Filter byReverseSegments = new ByReverseSegments();
        Filters filters = new Filters(byLongGroundTime, byDepartureDate, byReverseSegments);
        List<Flight> filteredFlights2 = filters.filter(collectionFlights, byDepartureDate);
        List<Flight> filteredFlights1 = filters.filter(collectionFlights, byLongGroundTime);
        List<Flight> filteredFlights3 = filters.filter(collectionFlights, byReverseSegments);
        System.out.println(collectionFlights);
        System.out.println(filteredFlights1);
        System.out.println(filteredFlights2);
        System.out.println(filteredFlights3);
    }
}
