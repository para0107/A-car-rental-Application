package ui;

import domain.Car;
import filter.FilterCarByYearRange;
import service.CarService;

import java.util.Scanner;

public class CarUI {
    private final CarService carService;
    private final Scanner scanner = new Scanner(System.in);

    public CarUI(CarService carService) {
        this.carService = carService;
    }

    public void run() {
        while (true) {
            System.out.println("\nCar Rental System");
            System.out.println("1. Add Car");
            System.out.println("2. Modify Car");
            System.out.println("3. Delete Car");
            System.out.println("4. View Car by ID");
            System.out.println("5. View All Cars");
            System.out.println("6. Filter Cars by Year Range");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    modifyCar();
                    break;
                case 3:
                    deleteCar();
                    break;
                case 4:
                    viewCarById();
                    break;
                case 5:
                    viewAllCars();
                    break;
                case 6:
                    filterCarsByYearRange();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addCar() {
        System.out.println("Enter Car ID:");
        String id = scanner.nextLine();
        System.out.println("Enter Car Model:");
        String model = scanner.nextLine();
        System.out.println("Enter Car Year:");
        int year = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(id, model, year);
        carService.addCar(car);
        System.out.println("Car added successfully.");
    }

    private void modifyCar() {
        System.out.println("Enter Car ID to modify:");
        String id = scanner.nextLine();
        Car car = carService.getCarById(id);
        if (car != null) {
            System.out.println("Enter new Car Model:");
            String model = scanner.nextLine();
            System.out.println("Enter new Car Year:");
            int year = scanner.nextInt();
            scanner.nextLine();

            car.setModel(model);
            car.setYear(year);
            carService.modifyCar(car);
            System.out.println("Car modified successfully.");
        } else {
            System.out.println("Car not found.");
        }
    }

    private void deleteCar() {
        System.out.println("Enter Car ID to delete:");
        String id = scanner.nextLine();
        carService.deleteCar(id);
        System.out.println("Car deleted successfully.");
    }

    private void viewCarById() {
        System.out.println("Enter Car ID:");
        String id = scanner.nextLine();
        Car car = carService.getCarById(id);
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("Car not found.");
        }
    }

    private void viewAllCars() {
        for (Car car : carService.getAllCars()) {
            System.out.println(car);
        }
    }

    private void filterCarsByYearRange() {
        System.out.println("Enter the start year:");
        int startYear = scanner.nextInt();
        System.out.println("Enter the end year:");
        int endYear = scanner.nextInt();
        scanner.nextLine();

        FilterCarByYearRange filter = new FilterCarByYearRange(startYear, endYear);
        for (Car car : carService.filterCars(filter)) {
            System.out.println(car);
        }
    }
}
