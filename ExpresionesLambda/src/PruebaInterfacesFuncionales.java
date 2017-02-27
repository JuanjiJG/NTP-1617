import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;

/**
 * Created by juanjo on 21/02/17.
 */
public class PruebaInterfacesFuncionales {

    public static void main(String args[]){
        // Expresión funcional para suma
        IntBinaryOperator exp1 = (int x, int y) -> {
            return x + y;
        };

        System.out.println("Operación binaria enteros: " + exp1.applyAsInt(3, 5));

        DoubleBinaryOperator expresion2 = (double x, double y) -> {
            return x + y;
        };

        System.out.println("Operación binaria dobles: " + expresion2.applyAsDouble(5.5, 3.7));

        //(double x, int y) -> {return x+y;};

        Consumer<Integer> expresion3 = valor -> System.out.println(valor);
        expresion3.accept(10);

        Runnable exp4 = () -> System.out.println("Expresión lambda sin argumentos.");
        exp4.run();
    }
}
