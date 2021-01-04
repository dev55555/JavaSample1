package streamapi.ex;

import java.util.HashSet;
import java.util.stream.Stream;

public class StreamDistinctObj {

  public static void main(String[] args) {
    var set = new HashSet<String>();
    Stream.of(
        new Person("山田", 40),
        new Person("高野", 30),
        new Person("大川", 35),
        new Person("山田", 45)
      )
      .filter(p -> set.add(p.name))
      .forEach(System.out::println);
  }
}

class Person {
      public String name;
      public int age;

      public Person(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return String.format("%s（%d歳）", this.name, this.age);
      }
}