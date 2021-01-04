package streamapi.ex;

import java.util.ArrayList;
import java.util.Arrays;

public class StreamBasic {
    public static void main(String[] args) {
        // データソースを準備
        var list = new ArrayList<String>(Arrays.asList("ant", "elephant", "hamster"));

        // ストリームによる処理
        list.
            stream().
            filter(s -> s.length() > 3).
            map(String::toUpperCase).
            forEach(System.out::println);
    }
}
