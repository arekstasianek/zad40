import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {

  private String Name;
  private String Surname;
  private LocalDate Birthdate;
  private String Ulica;
  private String Adres;

  public Student(String name, String surname, LocalDate birthdate, String ulica, String adres) {
    Name = name;
    Surname = surname;
    Birthdate = birthdate;
    Ulica = ulica;
    Adres = adres;
  }

  public String GetName() { return Name; }

  public String GetSurname() { return Surname; }

  public LocalDate GetBirthdate() { return Birthdate; }

  public String GetUlica() { return Ulica; }

  public String GetAdres() { return Adres; }

  public String ToString() {
    if (Birthdate != null) {
      return Name + " " + Surname + " " + Birthdate.format(DateTimeFormatter.ofPattern("dd_MM_yyyy")) + " " + Ulica + " " + Adres;
    }
    return Name + " " + Surname + " " + "Unknown" + " " + Ulica + " " + Adres;
}
public static Student Parse(String str) {
String[] data = str.split(" ");
if (data.length != 5)
return new Student("Parse Error", "Parse Error", null, "Parse Error", "Parse Error");
try {
LocalDate birthdate = LocalDate.parse(data[2], DateTimeFormatter.ofPattern("dd_MM_yyyy"));
return new Student(data[0], data[1], birthdate, data[3], data[4]);
} catch (java.time.format.DateTimeParseException e) {
System.out.println("Nie udało się sparsować daty urodzenia");
return new Student("Parse Error", "Parse Error", null, "Parse Error", "Parse Error");
}
}
}