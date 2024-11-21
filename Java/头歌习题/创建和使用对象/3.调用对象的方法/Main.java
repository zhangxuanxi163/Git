class MyClass {
    private void privateMethod() {
        System.out.println("Private method");
    }

    public void publicMethod() {
        System.out.println("Public method");
    }

    // 添加一个公有方法来调用私有方法
    public void callPrivateMethod() {
        this.privateMethod();
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        // 不直接调用私有方法，而是通过公有方法调用它
        // obj.privateMethod(); // 这会导致编译错误
        obj.callPrivateMethod(); // 间接调用私有方法
        obj.publicMethod(); // 直接调用公有方法
    }
}