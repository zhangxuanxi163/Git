import java.util.Scanner;
class MyClass {
    public void printMessage(String message) {
        System.out.println("Message: " + message);
    }
    
    public int addNumbers(int a, int b) {
        int sum = a + b;
        return sum;
    }
}
public class TestMethods{
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        /********** Begin **********/
        //创建MyClass类的对象
        MyClass myObject = new MyClass();
        
        //调用printMessage方法，参数为键盘接收的字符串
         Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        myObject.printMessage(message);
        
        //调用addNumbers方法，参数为键盘接收的两个整数，并输出计算结果
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int sum = myObject.addNumbers(number1, number2);
        System.out.println("Result: " + sum);

        /********** End **********/
        scanner.close();
    }
}