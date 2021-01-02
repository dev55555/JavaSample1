package enumuration;

public class Example03 {
    // 列挙型の個々での実装
    public enum Season {
        SPRING(0, "春") {
            @Override
            public void show() {
                System.out.println("春");
            }
        },
        SUMMER(1, "夏") {
            @Override
            public void show() {
                System.out.println("夏");
            }
        },
        AUTUMN(2, "秋") {
            @Override
            public void show() {
                System.out.println("秋");
            }
        },
        WINTER(4, "冬") {
            @Override
            public void show() {
                System.out.println("冬");
            }
        };

        // 列挙定数が実装するメソッド
        public abstract void show();

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
        Season.SPRING.show();
        Season.SUMMER.show();
        Season.AUTUMN.show();
        Season.WINTER.show();
        System.out.println("-----");

    }

}

