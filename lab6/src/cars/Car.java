package cars;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

public class Car implements Comparable<Car> {
    @JsonIgnore
    private int id;
    private String mark;
    private String model;
    private int year;
    private int price;
    private String number;
    private static int tempId;
    public Car(String mark, String model, int year, int price, String number) {
        tempId++;
        this.id = tempId;
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.price = price;
        this.number = number;
    }
    public Car() {
        this("", "", 0, 0, "");
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
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
    public void setYear(char year) {
        this.year = year;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id + ", mark='" + mark + '\'' + ", model='" + model + '\'' + ", year=" + year + ", price=" +
                price + "$" + ", number=" + number + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                year == car.year &&
                price == car.price &&
                number == car.number &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model);

    }
    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, year, price,number);
    }

    @Override
    public int compareTo(Car o) {
        int c = Integer.compare(o.price, price);
        if(c==0){
            return Integer.compare(year, o.year);
        }
        return c;
    }

}