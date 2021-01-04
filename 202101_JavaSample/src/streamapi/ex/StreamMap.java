package streamapi.ex;

import java.util.stream.Stream;

public class StreamMap {

  public static void main(String[] args) {
    Stream.of("バラ", "あさがお", "チューリップ", "さくら")
    .map(s -> s.length())
    .forEach(System.out::println);

//    Stream.of("バラ", "あさがお", "チューリップ", "さくら")
//    .mapToInt(s -> s.length())
//    .forEach(System.out::println);
  }
}
