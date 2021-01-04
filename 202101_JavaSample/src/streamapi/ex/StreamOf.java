package streamapi.ex;

import java.util.stream.Stream;

public class StreamOf {

  public static void main(String[] args) {
    var stream = Stream.of("first", "second", "third");
    stream.forEach(System.out::println);
  }
}
