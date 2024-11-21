public class Main {
	public static void main(String[] args) {
        /********** Begin **********/
        //创建Student类的对象
        Student student = new Student();


        //访问成员变量，将信息赋予该对象
        student.num = 1001;
        student.name = "张同学";
        student.sex = '男';
        student.score = 90.0;



        //分别调用该对象的两个方法
        student.show();
        student.study();
        



        /********** End **********/
	}
}
class Student {
	int num;
	String name;
	char sex;
	double score;
	void study() {
	   	System.out.println(name+"正在学习中！");
	}
	void show() {
	   	System.out.println("学号："+num+"  姓名："+name+"  性别："+sex+"  成绩："+score);
	}
}