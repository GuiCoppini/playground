package random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoceDeBatataDoce {

    static void printa(String frase) {
        String[] palavras = frase.split(" ");
        Map<String, Integer> mapa = new HashMap<>();

        for (String palavra : palavras) {
            if (mapa.containsKey(palavra)) {
                mapa.put(palavra, mapa.get(palavra) + 1);
            } else {
                mapa.put(palavra, 1);
            }
        }

        List<ParOrdenado> lista = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            lista.add(new ParOrdenado(entry.getKey(), entry.getValue()));
        }
        Collections.sort(lista);
        for (int i = lista.size() - 1; i >= 0; i--) {
            System.out.println(lista.get(i).palavra + " " + lista.get(i).aparicoes);
        }

    }



    public static void main(String[] args) {
        printa("batata doce mais doce que penis penis penis doce de batata doce");
    }
}
class ParOrdenado implements Comparable<ParOrdenado> {
    String palavra;
    Integer aparicoes;

    ParOrdenado(String a, Integer b) {
        palavra = a;
        aparicoes = b;
    }

    @Override
    public int compareTo(ParOrdenado o) {
        if (this.aparicoes > o.aparicoes) return 1;
        if (this.aparicoes < o.aparicoes) return -1;
        return 0;
    }
}
