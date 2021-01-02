package enumuration;

public class Example01 {
    // 列挙型の基本
    public enum Season {
        SPRING, SUMMER, AUTUMN, WINTER,
    }

    public static void main(String[] args) {
        // 列挙型を受け取るメソッドの例
        Example01 obj01 = new Example01();
        obj01.processSeason(Season.SPRING);

        System.out.println("-----");

        // インデックス番号:名前の形式で出力する例
        for (var season: Season.values()) {
            System.out.println(season.ordinal() + ":" + season.toString());
            System.out.println(season.ordinal() + ":" + season.name());
        }
        System.out.println("-----");

        // 文字列表現から列挙型を取得
        Season SPRING = Season.valueOf("SPRING");
        System.out.println(SPRING instanceof Season);
        System.out.println("-----");

    }

    // 列挙型を受け取るメソッドの例
    // Season型で定義されていない型は受け取れない。
    public void processSeason(Season season) {
        // 処理
    }
}

