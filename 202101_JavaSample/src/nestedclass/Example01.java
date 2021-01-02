package nestedclass;

// staticメンバークラス
public class Example01 {
    public static void main(String[] args) {
        System.out.println("-----");

        var myClass = new MyClassA();
        myClass.doit();
        System.out.println("-----");

        var helperB = new MyClassA.HelperB();
        helperB.show();
        System.out.println("-----");
    }
}

class MyClassA {
    private static class HelperA {
        public void show() {
            System.out.println("HelperA");
        }
    }
    public static class HelperB {
        public void show() {
            System.out.println("HelperB");
        }
    }
    public void doit() {
        var helperA = new HelperA();
        helperA.show();
    }
}

