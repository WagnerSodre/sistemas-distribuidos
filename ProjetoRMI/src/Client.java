import java.rmi.*;
import java.util.Scanner;

public class Client {
  public static void main(String a[]) throws Exception {
    Interface obj = (Interface) Naming.lookup("ADD");
    float m, x, y;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Valor de A: ");
    x = scanner.nextFloat();
    System.out.println("Valor de B: ");
    y = scanner.nextFloat();
    System.out.println("A soma dos números é: " + obj.add(x, y));
    System.out.println("A subtração dos números é: " + obj.sub(x, y));
    System.out.println("A multiplicação dos números é: " + obj.mult(x, y));
    System.out.println("A divisão dos números é: " + obj.div(x, y));
    m = obj.maiorMenor(x, y);
    if(m != 0)
        System.out.println("O maior dos números é: " + m);
    else
        System.out.println("Os números são iguais.");
  }
}