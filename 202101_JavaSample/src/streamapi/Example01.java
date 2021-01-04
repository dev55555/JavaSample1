package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// StreamAPI
public class Example01 {
    public static void main(String[] args) {
        // データソースを準備
        var list = new ArrayList<String>(Arrays.asList("ant", "elephant", "hamster"));
        // ストリームによる処理
        list.
            stream().
            filter(s -> s.length() > 3).
            map(String::toUpperCase).
            forEach(System.out::println);
        System.out.println("-----");

        // Streamの生成・・・コレクション、配列から作成する
        list = new ArrayList<String>(Arrays.asList("ant", "elephant", "hamster"));
        list.stream().forEach(System.out::println);
        // list.parallelStream().forEach(System.out::println);
        System.out.println("-----");

        var data = new String[] { "バラ", "あさがお", "チューリップ" };
        Arrays.stream(data).forEach(System.out::println);
        System.out.println("-----");

        var map = new HashMap<String, String>(
            Map.of("orange", "みかん", "apple", "りんご", "strawberry", "いちご"));
        map.entrySet().stream().forEach(System.out::println);
        System.out.println("-----");

    }
}
