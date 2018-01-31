import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("num: ");
        double a = Math.pow(3,sc.nextInt());
        for(long i = 0; i<a; i++) {
          for(long j = 0; j<a; j++) {
              System.out.print(inCarpet(i,j) ? " " : " ");
          }
          System.out.println();
        }
    }

    private static boolean inCarpet(long x, long y) {
      while(x != 0 && y != 0) {
          if(x%3 == 1 && y%3 ==1) return false;
          x /= 3;
          y /= 3;
      }
      return true;
    }
}
