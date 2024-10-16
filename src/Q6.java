import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q6 {
    public static void main(String[] args) throws Exception{
        Estado q0 =  new Estado("q0");
        Estado q1 =  new Estado("q1");

        Set<Estado> estados = new HashSet<>();
        estados.addAll(Arrays.asList(q0, q1));

        Set<Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q1);

        Estado estadoInicial = q0;

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.addAll(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, estadoInicial, estadosFinais);

        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q1);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q1);


        afd.verificarCadeia("10010");
    }
}