package domain;

public class Car implements Identifiable<String> {
    private String id;
    private String model;
    private int year;

    public Car(String id, String model, int year) {
        this.id = id;
        this.model = model;
        this.year = year;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{id='" + id + "', model='" + model + "', year=" + year + "}";
    }
}

