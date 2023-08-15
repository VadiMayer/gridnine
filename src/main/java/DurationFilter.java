import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DurationFilter implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        Map<Flight, List<Segment>> flightSegmentMap = new HashMap<>();
        for (Flight flight : flights) {
            flightSegmentMap.put(flight, flight.getSegments());
        }
        List<Flight> filter = new ArrayList<>();
        for (Map.Entry<Flight, List<Segment>> el: flightSegmentMap.entrySet()) {
            filter.add(new Flight(el.getKey().getSegments().stream().filter(e -> e.getDepartureDate() != null).toList()));
        }
        return filter;
    }
}
