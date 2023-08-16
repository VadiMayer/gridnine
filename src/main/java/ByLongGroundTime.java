import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ByLongGroundTime implements Filter {
    private int hours;

    public ByLongGroundTime(int hours) {
        this.hours = hours;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {

                    LocalDateTime arrival = null;
                    int groundTime = 0;

                    for (Segment segment : flight.getSegments()) {

                        if (arrival != null) {
                            groundTime += (int) Duration.between(arrival, segment.getDepartureDate()).toHours();
                        }

                        arrival = segment.getArrivalDate();
                    }

                    return groundTime > hours;

                })
                .collect(Collectors.toList());
    }
}
