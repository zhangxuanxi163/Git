//父类
class Animal {
    public void move() {
        System.out.println("动物在移动");
    }
}

//定义子类，并完成方法重写
class Dog extends Animal {
    @Override
    public void move() {
        System.out.println("狗在奔跑");
    }
}
//以上是考试要用的
public class Main {
    public static void main(String args[]) {
        Animal a = new Animal();// Animal对象
        Dog b = new Dog();    // Dog对象
        a.move();                // 执行Animal类的方法
        b.move();                // 执行Dog类的方法
    }
}