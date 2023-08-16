import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ByDepartureDate implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight ->
                        flight.getSegments().stream()
                                .anyMatch(segment -> segment.getDepartureDate().isBefore(now))
                )
                .collect(Collectors.toList());
    }
}
