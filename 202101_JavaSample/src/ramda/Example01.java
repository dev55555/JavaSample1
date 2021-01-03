package ramda;

// メソッド参照
public class Example01 {
    public static void main(String[] args) {
        String[] data = {"ab","cd","ef"};
        System.out.println("-----");

        // メソッド参照、ラムダ式を使用しない例
        MethodRefUnuse obj1 = new MethodRefUnuse();
        obj1.walkArray(data);
        System.out.println("-----");

        // メソッド参照の例
        MethodRefUse obj2 = new MethodRefUse();
        obj2.walkArray(data, MethodRefUse::addQuote);
        System.out.println("-----");

        // メソッドの差し替えも可能
        Counter c = new Counter();
        obj2.walkArray(data, c::addLength);
        System.out.println("" + c.getResult());

        System.out.println("-----");
    }
}

// メソッド参照、ラムダ式を使用しない例
class MethodRefUnuse {
    // 文字列配列の内容をブラケット付きで出力
    public void walkArray(String[] data) {
        for(var value : data) {
            System.out.printf("[%s]\n", value);
        }
    }
}

// メソッド参照の例
class MethodRefUse {
    // 配列要素の処理方法をメソッド参照で受け取れるように
    public void walkArray(String[] data, Output output) {
        for(var value : data) {
            output.print(value);
        }
    }
    // Output型に対応したメソッド(渡された文字列をブラケットで括る)
    static void addQuote(String value) {
        System.out.printf("[%s]\n", value);
    }
}
@FunctionalInterface
interface Output {
    void print(String str);
}

// メソッドの差し替えも可能
class Counter {
    private int result = 0;
    public int getResult() {
        return this.result;
    }
    public void addLength(String value) {
        this.result += value.length();
    }
}


