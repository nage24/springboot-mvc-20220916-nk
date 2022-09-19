package DI;

public class Test { // DITest 를 의존함. 그러나 그 대상은 생성자 호출시 어떤 객체를 의존할 지 결정됨.

    private DITest diTest;

    // private T1 t1;

    public Test(DITest diTest) { // !!!!!! 생성되는 시점에 어떤 객체 사용할 지 결정해주는 것이 DI 의존 주입
        // diTest = new DITestImpl();
        // t1 = new T1();
        // diTest = new DITestImpl2(); // <- 이 방식은 Test Class 의 코드를 바꾸고 있다.
        this.diTest = diTest;
    }

    public void show() {
        diTest.testPrint();
        // t1.t1print();
    }
}
