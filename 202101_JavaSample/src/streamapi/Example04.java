package streamapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//StreamAPI:終端処理
public class Example04 {

    public static void main(String[] args) {
        // 終端処理

        // それぞれの要素を順に処理する
        // void forEach​(Consumer<? super T> action)
        Stream.of("バラ", "あさがお", "チューリップ", "さくら")
        .forEach(v -> System.out.println(v));
        System.out.println("-----");

        // 最初の値を取得す
        // Optional<T> findFirst()
        var str1 = Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら", "もも")
                .filter(s -> s.startsWith("さ"))
                .findFirst();
        System.out.println(str1.orElse("－"));
        System.out.println("-----");

        // 値が特定の条件を満たすかを判定する
        // boolean allMatch​(Predicate<? super T> predicate)
        System.out.println(
                IntStream.of(1, 10, 5, -5, 12)
                  .allMatch(v -> v >= 0)
              );
        // boolean anyMatch​(Predicate<? super T> predicate)
        System.out.println(
                IntStream.of(1, 10, 5, -5, 12)
                  .anyMatch(v -> v >= 0)
              );
        System.out.println("-----");

        // 配列／コレクションに変換する
        // Object[] toArray()
        var list1 = Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                .filter(s -> s.startsWith("さ"))
                .toArray();
        System.out.println(list1[0]);

        // <R,​A> R collect​(Collector<? super T,​A,​R> collector)
        var list2 = Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                .filter(s -> s.startsWith("さ"))
                .collect(Collectors.toList());
        System.out.println(list2);

        //
        System.out.println(
                Stream.of(
                  new Person("山田太郎", "tyamada@example.com"),
                  new Person("鈴木花子", "hsuzuki@example.com"),
                  new Person("井上三郎", "sinoue@example.com"),
                  new Person("佐藤久美", "ksatou2@example.com"),
                  new Person("山田太郎", "yamataro@example.com")
                ).collect(Collectors.toMap(
                  Person::getName,
                  Person::getEmail,
                  (s, a) -> s + "/" + a
                  // (s, a) ->  a
                ))
              );
        System.out.println("-----");

        // 最小値／最大値を求める
        var str2 = Stream.of("めばる", "さんま", "ひらめ", "いわし", "ほっけ")
                .min(Comparator.naturalOrder());
              System.out.println(str2.orElse(""));
        System.out.println("-----");

        // 要素の個数を求める
        System.out.println(
                Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                  .filter(s -> s.length() > 3)
                  .count()
            );

        System.out.println("-----");

        // 合計値／平均値を求める
        var list = new int[] { 5, 1, 10, -3 };
        System.out.println(IntStream.of(list).sum());
        System.out.println(IntStream.of(list).average().orElse(0));
        System.out.println("-----");

        // ストリームの値を１つにまとめる
        // 引数が1つ
        System.out.println(
                  Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                    .sorted()
                    .reduce((result, str) -> {
                      return result + "," + str;
                    })
                    .orElse("")
                );
        // 引数が2つ
        System.out.println(
                  Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                    .sorted()
                    .reduce("ひまわり", (result, str) -> {
                      return result + "," + str;
                    })
                );
        // 引数が3つ
        System.out.println(
                  Stream.of("153", "211", "112", "350", "418", "208")
                    .parallel()
                    .reduce(0,
                      (result, value) -> {
                        return result + Integer.parseInt(value);
                      },
                      (result1, result2) -> {
                        return result1 + result2;
                      }
                  )
                );
        System.out.println("-----");

        // ストリーム内の要素をコレクションなどにまとめる１
        System.out.println(
                  Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                    .sorted()
                    .collect(
                      ArrayList<String>::new,
                      (listA, str) -> listA.add(str),
                      (listB, listC) -> listB.addAll(listC)
                    )
                );
        System.out.println("-----");

        // ストリーム内の要素をコレクションなどにまとめる２
        System.out.println(
                  Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                    .sorted()
                    .collect(
                      Collector.of(
                        ArrayList::new,
                        ArrayList::add,
                        (listX, listY) -> {
                            listX.addAll(listY);
                          return listX;
                        },
                        Collector.Characteristics.IDENTITY_FINISH
                      )
                    )
                );
        System.out.println("-----");

        // 標準のコレクターを利用する
        //
        System.out.println(
                Stream.of("バラ", "あさがお", "チューリップ", "さくら")
                  .sorted()
                  .collect(Collectors.joining(",", "<", ">"))
              );
        //
        System.out.println(
                Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                  .sorted()
                  .collect(
                    Collectors.groupingBy(str -> str.length()
                  ))
              );
        //
        System.out.println(
                Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                  .sorted()
                  .collect(
                    Collectors.groupingBy(
                      str -> str.length(),
                      Collectors.joining("/")
                  ))
              );
        //
        System.out.println(
                Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                  .sorted()
                  .collect(
                    Collectors.partitioningBy(
                      str -> str.length() > 3
                  )
                )
              );
        //
        System.out.println(
                Stream.of("バラ", "あさがお", "さざんか", "うめ", "さくら")
                  .sorted()
                  .collect(
                    Collectors.collectingAndThen(
                      Collectors.toList(),
                      Collections::unmodifiableList
                    )
                  )
              );
        //
        var summary = IntStream.of(5, 13, 7, 2, 30)
                  .collect(
                    IntSummaryStatistics::new,
                    IntSummaryStatistics::accept,
                    IntSummaryStatistics::combine
                  );
                System.out.println(summary.getMin());
                System.out.println(summary.getSum());
                System.out.println(summary.getAverage());

        System.out.println("-----");
    }
}

class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}