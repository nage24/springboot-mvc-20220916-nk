package DI;

public class TestMain {
    public static void main(String[] args) { // psvm
        Test test = new Test(new DITestImpl2()); // <- Test Class 코드는 안 고쳐도 됨.

        test.show();

    }
}
