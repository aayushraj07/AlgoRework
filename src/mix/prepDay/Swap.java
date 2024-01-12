package prepDay;

public class Swap {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        System.out.println("a  is " + a);
        System.out.println("b is " + b);

        swap(a,b);
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a  is " + a);
        System.out.println("b is " + b);
    }
}
