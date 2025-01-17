import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q7 {
    public static void main(String[] args) throws Exception{
        Estado q0 =  new Estado("q0");
        Estado q1 =  new Estado("q1");
        Estado q2 =  new Estado("q2");
        Estado q3 =  new Estado("q3");

        Set<Estado> estados = new HashSet<>();
        estados.addAll(Arrays.asList(q0, q1, q2, q3));

        Set<Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q3);

        Estado estadoInicial = q0;

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.addAll(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, estadoInicial, estadosFinais);

        afd.definirTransicoes(q0, '1', q0);
        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q2);
        afd.definirTransicoes(q2, '0', q3);
        afd.definirTransicoes(q2, '1', q0);
        afd.definirTransicoes(q3, '1', q3);
        afd.definirTransicoes(q3, '0', q3);

        afd.verificarCadeia("101101111110");
    }
}
