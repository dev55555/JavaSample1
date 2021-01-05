package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// StreamAPI:中間処理
public class Example03 {

    public static void main(String[] args) {

        // 中間処理
        // 指定された条件で値をフィルターする
        // Stream<T> filter​(Predicate<? super T> predicate)
        Stream.of( "https://www.shoeisha.co.jp/",
                   "SEshop",
                   "https://codezine.jp/",
                   "https://wings.msn.to/",
                   "WingsProject")
        .filter(s -> s.startsWith("https://"))
        .forEach(System.out::println);
        System.out.println("-----");

        // 与えられた値を加工する
        Stream.of("バラ", "あさがお", "チューリップ", "さくら")
        .map(s -> s.length())
        .forEach(System.out::println);
        Stream.of("バラ", "あさがお", "チューリップ", "さくら")
        .mapToInt(s -> s.length())
        .forEach(System.out::println);
        System.out.println("-----");

        // 与えられた要素を加工する
        var list = new String[][] {
            { "あいう", "かきく", "さしす" },
            { "たちつ", "なにぬ" },
            { "はひふ", "まみむ" }
          };
        Arrays.stream(list)
        .flatMap(v -> Arrays.stream(v))
        .forEach(System.out::println);
        Arrays.stream(list)
        .flatMap(v -> Arrays.stream(v).map(str -> str.substring(0, 1)))
        .forEach(System.out::println);
        System.out.println("-----");

        // 要素を並び変える
        Stream.of("バラ", "あさがお", "チューリップ", "さくら")
        .sorted()
        .forEach(System.out::println);
        System.out.println("-");

        Stream.of("バラ", "あさがお", "チューリップ", "さくら")
        .sorted((str1, str2) -> str1.length() - str2.length())
        .forEach(System.out::println);
        System.out.println("-");

        Stream.of("バラ", "あさがお", "チューリップ", "さくら")
        .sorted(Comparator.reverseOrder())
        .forEach(System.out::println);
        System.out.println("-----");

        // m～n番目の要素を取り出す
        IntStream.range(1, 15)
        .skip(4)
        .limit(10)
        .forEach(System.out::println);
        System.out.println("-----");

        // 先頭から条件を満たす間までの値を除去する
        IntStream.of(-2, -5, 0, 3, -1, 2)
        .dropWhile(i -> i < 0)
        .forEach(System.out::println);
        System.out.println("-----");

        // 先頭から条件を満たす間までの値だけを取り出す
        IntStream.of(-2, -5, 0, 3, -1, 2)
        .takeWhile(i -> i < 0)
        .forEach(System.out::println);
        System.out.println("-----");

        // ストリームの途中状態を確認する
        Stream.of("さかな", "あか", "こだま", "きんもくせい")
        .peek(System.out::println)
        .sorted()
        .forEach(System.out::println);
        System.out.println("-----");

        // 値の重複を除去する
        Stream.of("あか", "さかな", "あか", "こだま", "こだま")
        .distinct()
        .forEach(System.out::println);
        System.out.println("-");

        var set = new HashSet<String>();
        Stream.of(
            new Person1("山田", 40),
            new Person1("高野", 30),
            new Person1("大川", 35),
            new Person1("山田", 45)
          )
          .filter(p -> set.add(p.name))
          .forEach(System.out::println);
        System.out.println("-----");

        // 基本型ストリームの変換
        IntStream.range(1, 5)
        .asDoubleStream()
        .forEach(System.out::println);
        System.out.println("-");

        IntStream.range(1, 5)
        .boxed()
        .forEach(System.out::println);
        System.out.println("-");

        IntStream.range(1, 5)
        .mapToObj(Integer::valueOf)
        .forEach(System.out::println);
        System.out.println("-");

        Stream.of(1, 2, 3, 4)
        .mapToInt(i -> i)
        .forEach(System.out::println);
        System.out.println("-----");
    }
}


class Person1 {
    public String name;
    public int age;

    public Person1(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return String.format("%s（%d歳）", this.name, this.age);
    }
}