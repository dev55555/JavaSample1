package enumuration;

public class Example02 {
    // 列挙型のメンバー定義
    public enum Season {
        SPRING(0, "春"),
        SUMMER(1, "夏"),
        AUTUMN(2, "秋"),
        WINTER(4, "冬");

        // フィールドの宣言
        private int code;
        private String jpName;

        // コンストラクター
        private Season(int code, String jpName) {
            this.code = code;
            this.jpName = jpName;
        };

        // メソッド
        public int toSeasonValue() {
            return this.code;
        }

        @Override
        public String toString() {
            return this.jpName;
        }

    }

    public static void main(String[] args) {
        System.out.println("-----");
        System.out.println("" + Season.SPRING);
        System.out.println("" + Season.SPRING.toString());
        System.out.println("" + Season.SPRING.toSeasonValue());
        System.out.println("-----");

    }

}

