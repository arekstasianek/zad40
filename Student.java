public class Student {

  private String Name;
  private String Surname;
  private int Age;
  private String Ulica;
  private String Adres;

  public Student(String name, String surname, int age, String ulica, String adres) {
    Name = name;
    Surname = surname;
    Age = age;
    Ulica = ulica;
    Adres = adres;
  }

  public String GetName() {return Name;}
  public String GetSurname() {return Surname;}
  public int GetAge() {return Age;}
  public String GetUlica() {return Ulica;}
  public String GetAdres() {return Adres;}

  public String ToString() {
    return Name + " " + Surname + " " + Integer.toString(Age) + " " + Ulica + " " + Adres;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 5) 
      return new Student("Parse Error", "Parse Error", -1, "Parse Error", "Parse Error");
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
  }
}