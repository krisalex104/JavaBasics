package operator;

public class Test3 {
    public static void main(String[] args) {
        {
            int x = 15;
            int y = x++;
            int  z = ++x;
            System.out.println(y +" " + z);
        }
    }
}
