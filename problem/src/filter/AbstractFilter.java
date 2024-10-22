package filter;

import domain.Car;

public interface AbstractFilter<T> {
    boolean accept(T entity);
}