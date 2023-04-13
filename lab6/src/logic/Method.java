package logic;

import cars.Car;

import java.util.*;
import java.util.stream.Collectors;

public class Method {
    public void addCar(List<Car> list, String mark, String model, int year, int price, String number) {
        Car car = new Car(mark, model, year, price, number);
        list.add(car);
    }
    public void removeCar(int carToDelete, List<Car> list) {
        if (list.isEmpty()) {
            return;
        }
        boolean remove = list.removeIf(car -> car.getId() == carToDelete);
        if (!remove) {
            return;
        }
    }

    public void showAllCars(List<Car> list) {
        if (list.isEmpty()) {
            return;
        }
        list.forEach(System.out::println);
    }

    public List<Car> searchMarkAndSortYear(String mark, List<Car> list) {
        return list.stream()
                .filter(car -> car.getMark().equals(mark))
                .sorted(Comparator.comparingInt(Car::getYear))
                .collect(Collectors.toList());
    }

    public List<Car> searchMarkAndYear(String mark, List<Car> list, int year) {
        return list.stream()
                .filter(car -> car.getMark().equals(mark) && (2022 - car.getYear()) > year)
                .collect(Collectors.toList());
    }

   public List<Car> searchYearAndPrice(List<Car> list, int enterY, int enterP) {
       return list.stream()
               .filter(car -> car.getYear() == enterY && car.getPrice() > enterP)
               .collect(Collectors.toList());
   }

    public boolean inputValidate(String input) {
        if (input.contains(" ") || input.contains("\n") ||
                input.contains("\t") || input.isEmpty()) {
            return false;
        }
        return true;
    }

    public void printSortPriceAndYear(List<Car> list) {
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static List<Car> getMarkSortedCars(List<Car> list) {
        Map<String, List<Car>> carMap = list.stream()
                .collect(Collectors.groupingBy(Car::getMark));

        List<Car> sortedCars = new ArrayList<>();
        carMap.forEach((mark, carList) -> {
            carList.stream()
                    .sorted(Comparator.comparing(Car::getModel))
                    .forEach(sortedCars::add);
        });
        return sortedCars;
    }

    public static void printCarsByMark(List<Car> list) {
        Map<String, List<Car>> carMap = getMarkSortedCars(list).stream()
                .collect(Collectors.groupingBy(Car::getMark));

        carMap.forEach((mark, carList) -> {
            System.out.println("Mark: " + mark);
            carList.forEach(car -> {
                System.out.println("Car{" +
                        "id=" + car.getId() + ", model='" + car.getModel() + '\'' + ", year=" + car.getYear() + ", price=" + car.getPrice() + "$" + ", number=" + car.getNumber() + '}');
            });
            System.out.println();
        });
    }




}

