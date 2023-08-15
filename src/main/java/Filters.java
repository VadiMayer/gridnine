import java.util.Arrays;
import java.util.List;

public class Filters {
    private List<Filter> filters;

    public Filters(Filter... filters) {
        this.filters = Arrays.asList(filters);
    }

    public List<Flight> filter(List<Flight> flights, Filter howToFilter) {
        for(Filter filter : filters) {
            if (filter.getClass().equals(howToFilter.getClass())) {
                flights = filter.filter(flights);
            }
        }
        return flights;
    }
}
