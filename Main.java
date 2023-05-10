/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();

      Scanner scanner = new Scanner(System.in);
      int option;

      System.out.println("Opcje:");
      System.out.println("1 dodaj nowego studenta");
      System.out.println("2 wypisz studentów");
      System.out.println("0 wyjscie");

      option = scanner.nextInt();

      switch (option) {
        case 1:
          System.out.println("Podaj imie studenta");
          String name = scanner.next();
          System.out.println("Podaj nazwisko studenta");
          String surname = scanner.next();
          System.out.println("Podaj wiek studenta");
          int age = scanner.nextInt();
          System.out.println("Podaj ulicę studenta");
          String ulica = scanner.next();
          System.out.println("Podaj adres studenta");
          String adres = scanner.next();
          s.addStudent(new Student(name, surname, age, ulica, adres));
          return;
        case 2:
          break;
        case 0:
          System.out.println("Wybrano opcje wyjscie");
          System.exit(0);
          break;
      }

      var students = s.getStudents();
      for(Student current : students) {
        System.out.println(current.ToString());
      }
    } catch (IOException e) {

    }
  }
}