package filter;
import domain.Car;

public class FilterCarByYear implements AbstractFilter<Car> {
    private int year;

    public FilterCarByYear(int year) {
        this.year = year;
    }

    @Override
    public boolean accept(Car car) {
        return car.getYear() == year;
    }
}
