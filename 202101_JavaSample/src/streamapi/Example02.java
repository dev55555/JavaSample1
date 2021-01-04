package streamapi;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// StreamAPI:Streamの生成
public class Example02 {
    public static void main(String[] args) {

        // ofメソッド
        // static <T> Stream<T> of​(T t)
        var streamOf = Stream.of("first", "second", "third");
        streamOf.forEach(System.out::println);
        System.out.println("-----");

        // generateメソッド
        // static <T> Stream<T> generate​(Supplier<? extends T> s)
        var streamGenerate = Stream.generate(() -> {
            var r = new Random();
            return r.nextInt(100);
          });
        streamGenerate.limit(10).forEach(System.out::println);
        System.out.println("-----");

        // iterateメソッド
        // static <T> Stream<T> iterate​(T seed, UnaryOperator<T> f)
        var streamIterate = Stream.iterate(1, (num) -> {
            return num * 2;
          });
        streamIterate.limit(10).forEach(System.out::println);
        System.out.println("-----");

        // builderメソッド
        // static <T> Stream.Builder<T> builder()
        var builder = Stream.builder()
                .add("いちじく")
                .add("にんじん")
                .add("さんしょ");
        // Stream<T> build()
        builder.build().forEach(System.out::println);
        System.out.println("-----");

        // concatメソッド
        // static <T> Stream<T> concat​(Stream<? extends T> a, Stream<? extends T> b)
        var stream1 = Stream.of("いちじく", "にんじん", "さんしょ");
        var stream2 = Stream.of("しいたけ", "ごぼう", "むくろじゅ");
        Stream.concat(stream1, stream2)
          .forEach(System.out::println);
        System.out.println("-----");

        // 基本型ストリームの生成
        IntStream.range(10, 15)
        .forEach(System.out::println);
        System.out.println("-----");
        IntStream.rangeClosed(10, 15)
        .forEach(System.out::println);
        System.out.println("-----");
    }
}
