val zahl = 123
val foo = "1213"

// Funktionen
def f(n: Int) = n + 1

f(5)

// Klassen
class Person(val name: String) {
  def sayHello() = {
    println("Hallo, " +name)
  }
}

val Peter = new Person("Peter")
Peter.sayHello()

//Traits, um Klassen zu erweitern

trait ByeBye {
  def sayGoodbye = {
    println("Bye")
  }
  def sayHello() = {
    print("Hi")
  }
}

class Klaus() extends Person("Klaus") with ByeBye {
  override def sayHello() = {
    print("asdf")
  }
}

new Klaus().sayGoodbye

object Julian extends Person("Julian")

// case classes, wenn man Klassen als Datencontainer verwendet
trait UniPerson
case class Student(val Matrikelnr: Int) extends UniPerson
case class Professor(val Fachgebiet: String) extends UniPerson

Student(123) == Student(123)

// Pattern Matching, hier kann eine Funktion mehrere Verhalten für mehrere Klassen besitzen
// man könnte auch eine abstrakte Methode definieren & diese dann in den case classes überschreiben
def showUniPerson(p: UniPerson): String = 
  p match {
    case Student(m) => "Studentnr. " + m
    case Professor(m) => "Prof im Gebiet: " + m
  }

showUniPerson(Student(12351234))
