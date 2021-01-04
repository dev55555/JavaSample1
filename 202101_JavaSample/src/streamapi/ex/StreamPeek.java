package streamapi.ex;

import java.util.stream.Stream;

public class StreamPeek {

  public static void main(String[] args) {
    Stream.of("さかな", "あか", "こだま", "きんもくせい")
      .peek(System.out::println)
      .sorted()
      .forEach(System.out::println);
  }
}
