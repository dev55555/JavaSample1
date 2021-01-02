package nestedclass;

// 非staticメンバークラス
public class Example02 {
    public static void main(String[] args) {
        System.out.println("-----");
        var obj = new MyClassB();
        obj.doit();
        System.out.println("-----");
    }
}

class MyClassB {
    private String str1 = "包含：インスタンス";
    private static String str2= "包含：クラス";

    // 内部クラスの定義
    private class MyHelper {
        private String str1 = "ネスト：インスタンス";
        private final static String str2= "ネスト：クラス";

        public void show() {
            System.out.println(MyClassB.this.str1);
            System.out.println(MyClassB.str2);
        }
    }

    public void doit() {
        var helper = new MyHelper();
        helper.show();
        System.out.println(helper.str1);
        System.out.println(MyHelper.str2);
    }
}

