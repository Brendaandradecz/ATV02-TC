import java.util.*;

public class AutomatoFinitoDeterministico {
    private Set<Estado> estados;
    private Set<Character> alfabeto;
    private Estado estadoInicial;
    private  Set<Estado> estadosFinais;
    Map<Estado, Map<Character, Estado>> funcaoDeTransicao;

    public AutomatoFinitoDeterministico(Set<Estado> estados, Set<Character> alfabeto, Estado estadoInicial, Set<Estado> estadosFinais) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.funcaoDeTransicao = new HashMap<>();

        for (Estado estado : this.estados){
            this.funcaoDeTransicao.put(estado, new HashMap<>());
        }
    }

    public void definirTransicoes(Estado estadoOrigem, Character simbolo, Estado estadoDestino){
        this.funcaoDeTransicao.get(estadoOrigem).put(simbolo, estadoDestino);
    }
    public void verificarCadeia(String cadeia) throws Exception {
        Estado estadoAtual = estadoInicial;
        for (char simbolo : cadeia.toCharArray()){
            if(!this.alfabeto.contains(simbolo)){
                throw new Exception("Simbolo Invalido");
            }
            estadoAtual = funcaoDeTransicao.get(estadoAtual).get(simbolo);
        }

        if (estadosFinais.contains(estadoAtual)){
            System.out.println("Cadeia Aceita");
        } else {
            System.out.println("Cadeia Rejeitada");
        }
    }
}