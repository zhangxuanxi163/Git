class TestClass {
    //printMessage()方法根据参数的类型和个数不同实现重载
    /********** Begin **********/
    //1. 接收一个字符串参数
  public void printMessage(String message) {
        System.out.println("Message: " + message);
    }


    //2. 接收一个整数参数
    public void printMessage(int number) {
        System.out.println("Number: " + number);
    }


    //3. 接收一个字符串参数和一个整数参数。
   public void printMessage(String message, int number) {
        System.out.println("Message: " + message);
        System.out.println("Number: " + number);
    }


    /********** End **********/
    


    //addNumbers()方法根据参数的类型不同实现重载
    /********** Begin **********/
    //1. 两个整型参数，计算两数的和
    public int addNumbers(int num1, int num2) {
        return num1 + num2;
    }


    //2. 两个浮点类型参数，计算两数的和
   public double addNumbers(double num1, double num2) {
        return num1 + num2;
    }


    /********** End **********/
}
//上面是考试要用的
public class Practice2 {
    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.printMessage("Hello World!");
        tc.printMessage(2024);
        tc.printMessage("Hello World!",2024);
        System.out.println("Result: "+tc.addNumbers(3,7));
        System.out.println("Result: "+tc.addNumbers(3.5,4.2));
    }
}