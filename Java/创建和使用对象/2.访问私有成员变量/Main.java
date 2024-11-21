public class Main {
    public static void main(String[] args) {
          MyClass obj = new MyClass ();
          //obj.name = "John"; 
          obj.age = 20; 

          //输出name的值
          System.out.println("Name: " + obj.getName());
          //修改name的值为Alice
          obj.setName("Alice");
          //输出name的值
          System.out.println("Name: " + obj.getName());
    }
}
//只有上面的考试要用
class  MyClass {
    private String name;
    public int age;
       
    public String getName() {
        return name;
    }
   
    public void setName(String name) {
        this.name = name;
    }
}