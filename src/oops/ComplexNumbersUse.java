package oops;

public class ComplexNumbersUse {
    public static void main(String[] args) {
        ComplexNumbers c=new ComplexNumbers(2,3);
        c.print();

        ComplexNumbers c2=new ComplexNumbers(4,5);
        c.plus(c2);
        c.print();

        c.multiply(c2);
        c.print();
    }
}
