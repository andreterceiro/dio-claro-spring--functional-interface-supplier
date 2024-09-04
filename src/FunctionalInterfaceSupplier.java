import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class to execute tests related to the functional interface supplier
 */
public class FunctionalInterfaceSupplier {
    /**
     * Main method to execute manual tests through CLI
     *
     * @param args CLI arguments (ignored)
     */
    public static void main(String[] args) throws Exception {
        FunctionalInterfaceSupplier.forma1();
        System.out.println("----------------");
        FunctionalInterfaceSupplier.forma2();
        System.out.println("----------------");
        FunctionalInterfaceSupplier.forma3();
        System.out.println("----------------");
        FunctionalInterfaceSupplier.forma4();
    }

    /**
     * Way 1 to use the functional interface supplier
     */
    private static void forma1() {
        Supplier<String> saudacao = () -> "Seja bem vindo pela forma 1";

        List<String> listaSaudacoes = Stream
            .generate(saudacao)
            .limit(2)
            .collect(Collectors.toList());

        listaSaudacoes.forEach(s -> System.out.println(s));
    }

    /**
     * Way 2 to use the functional interface supplier
     */
    private static void forma2() {
        Supplier<String> saudacao = () -> "Seja bem vindo pela forma 2";

        List<String> listaSaudacoes = Stream
            .generate(saudacao)
            .limit(2)
            .collect(Collectors.toList());

        // This time we will use the method reference under this message
        // This is the only difference from forma1()
        listaSaudacoes.forEach(System.out::println);
    }

    /**
     * Way 3 to use the functional interface supplier
     */
    private static void forma3() {
        List<String> listaSaudacoes = Stream
            .generate(
                new Supplier<String>() {
                    @Override
                    public String get() {
                        return "Seja bem vindo pela forma 3";
                    }
                }
            )
            .limit(2)
            .collect(Collectors.toList());

        // This time we will use the method reference under this message
        // This is the only difference from forma1()
        listaSaudacoes.forEach(System.out::println);
    }

    /**
     * Way 4 to use the functional interface supplier
     */
    private static void forma4() {
        List<String> listaSaudacoes = Stream
            .generate(() -> "Seja bem vindo pela forma 4")
            .limit(2)
            .collect(Collectors.toList());

        // This time we will use the method reference under this message
        // This is the only difference from forma1()
        listaSaudacoes.forEach(System.out::println);
    }

}
