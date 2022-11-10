import java.util.HashMap;
import java.util.Map;

public class Saudacao {
    String formalidade;
    Map<String, String> saudacoes = new HashMap<String, String>();

    public void setFormalidade(String formalidade) {
        this.formalidade = formalidade;
    }

    // addSaudacoes("formal", "Bom dia, sr.")
    // addSaudacoes("casual", "E aí, blz?")
    // addSaudacoes("intimo", "Oi querida!")
    public void addSaudacoes(String formalidade, String saudacao) {
        this.saudacoes.put(formalidade, saudacao);
    }

    public String saudar() {
        String saudacao = this.saudacoes.get(this.formalidade);

        if (saudacao == null) {
            return "Oi.";
        }

        return saudacao;
    }
}
