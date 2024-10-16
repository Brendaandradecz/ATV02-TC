import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q4 {
    public static void main(String[] args) throws Exception{
        Estado q0 =  new Estado("q0");
        Set<Estado> estados = new HashSet<>();
        estados.addAll(Arrays.asList(q0));

        Set<Estado> estadosFinais = new HashSet<>();
        //estadosFinais.add();

        Estado estadoInicial = q0;

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.addAll(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, estadoInicial, estadosFinais);

        afd.definirTransicoes(q0, '0', q0);
        afd.definirTransicoes(q0, '1', q0);


        afd.verificarCadeia("0000010000000");
    }
}
