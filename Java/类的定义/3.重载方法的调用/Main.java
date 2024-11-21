public class  Main{
	public static void main(String args[]){
		MyClass d1 = new MyClass();
		System.out.println(d1.add(3,2));   //计算两数之和5
		System.out.println(d1.add(3));     //计算累加1
		System.out.println(d1.add(3.2f,2.0));    //计算两数之差1.2000000476837158
		System.out.println(d1.add(3,2.0));  //计算两数之积6.0
	}
}
class MyClass{
	//实现add()方法的重载，满足Main程序中的调用
    /********** Begin **********/
    // 两个整型参数，计算两数之和
    public int add(int a, int b) {
        return a + b;
    }

    // 一个整型参数，计算累加
    public int add(int a) {
        return a + 1;
    }

    // 两个浮点型参数，计算两数之差
    public float add(float a, float b) {
        return a - b;
    }

    // 一个整型和一个双精度浮点型参数，计算两数之积
    public double add(int a, double b) {
        return a * b;
    }

    // 一个浮点型和一个双精度浮点型参数，计算两数之差
    public double add(float a, double b) {
        return a - b;
    }
    /********** End **********/
}