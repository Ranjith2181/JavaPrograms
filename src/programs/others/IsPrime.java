package programs.others;

public class IsPrime {

    public static void main(String[] args) {
        int num = 15;
        System.out.println(" Number is prime or not "+isPrime(num));
    }

    private static boolean isPrime(int num){
        for(int i=2;i<=(num/2);i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
