import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

class MainTest {
    private List<Flight> flights;

    @BeforeEach
    public void setUp() {
        flights = FlightBuilder.createFlights();
    }

    @Test
    public void testByDepartureDate() {
        Filter filter = new ByDepartureDate();
        List<Flight> filtered = filter.filter(flights);

        Assertions.assertEquals(1, filtered.size());
        Assertions.assertTrue(filtered.get(0).getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now()));
    }

    @Test
    public void testByLongGroundTime() {
        Filter filter = new ByLongGroundTime(2);
        List<Flight> filtered = filter.filter(flights);

        Assertions.assertEquals(2, filtered.size());
        Assertions.assertTrue(hasByLongGroundTime(filtered.get(0)));
        Assertions.assertTrue(hasByLongGroundTime(filtered.get(1)));
    }

    private boolean hasByLongGroundTime(Flight flight) {
        LocalDateTime arrival = null;
        long groundTime = 0;

        for (Segment segment : flight.getSegments()) {

            if (arrival != null) {
                long hours = Duration.between(arrival, segment.getDepartureDate()).toHours();
                groundTime += hours;
            }

            arrival = segment.getArrivalDate();

        }
        return groundTime > 2;
    }

    @Test
    void testByReverseSegments() {
        Filter filter = new ByReverseSegments();
        List<Flight> filtered = filter.filter(flights);

        Assertions.assertEquals(1, filtered.size());

        Flight flight = filtered.get(0);
        List<Segment> segments = flight.getSegments();

        Assertions.assertTrue(segments.get(0).getDepartureDate().isAfter(segments.get(0).getArrivalDate()));
    }

}