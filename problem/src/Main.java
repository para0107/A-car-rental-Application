import domain.Car;
import repository.MemoryRepository;
import service.CarService;
import ui.CarUI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MemoryRepository<String, Car> carRepo = new MemoryRepository<>();
        CarService carService = new CarService(carRepo);
        CarUI carUI = new CarUI(carService);

        carService.addCar(new Car("1", "Corola", 2020));
        carService.addCar(new Car("2", "BMW", 2010));
        carService.addCar(new Car("3", "Ford", 1997));
        carService.addCar(new Car("4", "Honda", 2000));
        carService.addCar(new Car("5", "Honda", 1990));

        carUI.run();
        }
    }
