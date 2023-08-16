import java.util.List;
import java.util.stream.Collectors;

public class ByReverseSegments implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight ->
                        flight.getSegments().stream()
                                .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                )
                .collect(Collectors.toList());
    }
}
