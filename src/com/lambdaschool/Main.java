package com.lambdaschool;

import java.util.ArrayList;

public class Main {
  public static void printVehicles(ArrayList<AbstractVehicle> vehicles, CheckVehicle tester) {
    for(AbstractVehicle v : vehicles) {
      if (tester.test(v)) {
        System.out.println(v.getName());
      }
    }
  }

  public static void main(String[] args) {
    Horse seabiscuit = new Horse("Seabiscuit", 10);
    Horse joe = new Horse("Joe");
    Horse affirmed = new Horse("Affirmed");

    HorseFromVehicle seattleSlew = new HorseFromVehicle("Seattle Slew", 10);

    ArrayList<AbstractVehicle> myList = new ArrayList<>();
    myList.add(new HorseFromVehicle("Secretariat"));
    myList.add(new HorseFromVehicle("Trigger"));
    myList.add(new HorseFromVehicle("Seattle Slew"));
    myList.add(new HorseFromVehicle("American Pharaoh"));
    myList.add(new Auto("F150", 10));
    myList.add(new Auto("Camry", 10));
    myList.add(new Auto("Civic", 25));

    // Lambda Expression
    System.out.println("*** List all vehicles with fuel greater than 5 ***");
    printVehicles(myList, v -> v.getFuelLevel() > 5);

    System.out.println("\n*** List all vehicles with a path of Grass ***");
    printVehicles(myList, v -> v.getPath().equals("Grass"));

    System.out.println("\n*** Sort vehicle list by name ***");
    myList.sort((v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
    myList.forEach(v -> System.out.println(v.getName()));

    System.out.println("\n*** Sort vehicle list by fuel level ***");
    //noinspection ComparatorCombinators
    myList.sort((v1, v2) -> v1.getFuelLevel() - v2.getFuelLevel());
    myList.forEach(System.out::println);

    System.out.println("\n*** List all vehicles with a fuel level between 5 and 15");
    printVehicles(myList, v -> v.getFuelLevel() >= 5 && v.getFuelLevel() <= 15);
  }
}
