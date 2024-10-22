package service;

import domain.Car;
import filter.AbstractFilter;
import repository.IRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class CarService {
    private final IRepository<String, Car> carRepository;

    public CarService(IRepository<String, Car> carRepository) {
        this.carRepository = carRepository;
    }

    public void addCar(Car car) {
        carRepository.add(car);
    }

    public void modifyCar(Car car) {
        carRepository.modify(car);
    }

    public void deleteCar(String id) {
        carRepository.delete(id);
    }

    public Car getCarById(String id) {
        return carRepository.findById(id);
    }

    public Collection<Car> getAllCars() {
        return carRepository.getAll();
    }
    public Collection<Car> filterCars(AbstractFilter<Car> filter) {
        Collection<Car> allCars = carRepository.getAll();
        Collection<Car> filteredCars = new ArrayList<>();

        for (Car car : allCars) {
            if (filter.accept(car)) {
                filteredCars.add(car);
            }
        }

        return filteredCars;
    }

}
