//父类
class Animal {
    String name;

    public void eat() {
        System.out.println("Animal is eating.");
    }
}


//子类
/********** Begin **********/
class Dog extends Animal {
    
    // 重写父类的 eat 方法
    @Override
    public void eat() {
        System.out.println("Animal is eating.");
    }

    // 子类特有的方法，狗会叫
    public void bark() {
        System.out.println("Dog is barking.");
    }
}


/********** End **********/