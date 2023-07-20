class Student{
    static int a = 10;
    int b = 20;
    void fun2()
    {
        System.out.println("from m2");
    }
}
class Test {
    public static void main (String[] args) {
        Student s = new Student();
    }
}