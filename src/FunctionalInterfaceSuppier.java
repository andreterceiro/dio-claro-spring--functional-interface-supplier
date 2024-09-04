import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalInterfaceSuppier {
    public static void main(String[] args) throws Exception {
        FunctionalInterfaceSuppier.forma1();
    }

    private static void forma1() {
        Supplier<String> saudacao = () -> "Seja bem vindo pela forma 1";

        List<String> listaSaudacoes = Stream
            .generate(saudacao)
            .limit(5)
            .collect(Collectors.toList());

        listaSaudacoes.forEach(s -> System.out.println(s));
    }
}
