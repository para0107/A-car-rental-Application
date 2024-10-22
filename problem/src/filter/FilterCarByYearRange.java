package filter;

import domain.Car;

public class FilterCarByYearRange implements AbstractFilter<Car> {
    private int startYear;
    private int endYear;

    public FilterCarByYearRange(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
    }

    @Override
    public boolean accept(Car car) {
        int carYear = car.getYear();
        return carYear >= startYear && carYear <= endYear;
    }
}
