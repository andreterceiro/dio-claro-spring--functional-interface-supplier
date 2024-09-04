import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalInterfaceSuppier {
    public static void main(String[] args) throws Exception {
        FunctionalInterfaceSuppier.forma1();
        FunctionalInterfaceSuppier.forma2();
    }

    private static void forma1() {
        Supplier<String> saudacao = () -> "Seja bem vindo pela forma 1";

        List<String> listaSaudacoes = Stream
            .generate(saudacao)
            .limit(2)
            .collect(Collectors.toList());

        listaSaudacoes.forEach(s -> System.out.println(s));
    }

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
}
