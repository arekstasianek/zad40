/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();

      Scanner scanner = new Scanner(System.in);
      int option;

      System.out.println("Opcje:");
      System.out.println("1 dodaj nowego studenta");
      System.out.println("2 wypisz studentów");
      System.out.println("3 wyszukaj i wypisz studenta");
      System.out.println("0 wyjscie");

      option = scanner.nextInt();

      switch (option) {
        case 1:
          System.out.println("Podaj imie studenta");
          String name = scanner.next();
          System.out.println("Podaj nazwisko studenta");
          String surname = scanner.next();
          System.out.println("Podaj date urodzenia studenta (DD-MM-YYYY)");
          String birthdateStr = scanner.next();
          try {
            LocalDate birthdate = LocalDate.parse(birthdateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.println("Podaj ulicę studenta");
            String ulica = scanner.next();
            System.out.println("Podaj adres studenta");
            String adres = scanner.next();
            s.addStudent(new Student(name, surname, birthdate, ulica, adres));
          } catch (DateTimeParseException e) {
            System.out.println("Niepoprawny format daty. Podaj datę w formacie DD-MM-YYYY.");
          }
          return;
        case 2:
          var students = s.getStudents();
          for (Student current : students) {
            System.out.println(current.ToString());
          }
          break;
        case 3:
          System.out.println("Podaj imie studenta");
          String searchName = scanner.next();
          Student foundStudent = s.findStudentByName(searchName);
          if (foundStudent != null) {
            System.out.println(foundStudent.ToString());
          } else {
            System.out.println("Nie znaleziono studenta o podanym imieniu.");
          }
          break;
        case 0:
          System.out.println("Wybrano opcje wyjscie");
          System.exit(0);
          break;
      }

    } catch (IOException e) {

    }
  }
}
