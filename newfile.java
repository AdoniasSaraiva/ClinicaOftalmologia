import java.*;

class Main {
public static void main(String[] args) {
  
int dividendo=20;
int divisor=0;
float resultado;

try{
resultado=dividendo/divisor;
System.out.println("Resultado da divisão:"+resultado);
  
}catch(ArithmeticException e){
  System.out.println("Não é possivel dividir por 0");
}
}}

