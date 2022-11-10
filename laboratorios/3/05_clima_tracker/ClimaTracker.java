public class ClimaTracker {
    String condicaoAtual;
    Notificador notificador;

    public ClimaTracker(Notificador notificador) {
        this.notificador = notificador;
    }

    public void setCondicaoAtual(String condicaoClimatica) {
        this.condicaoAtual = condicaoClimatica;

        this.notificador.notificar(condicaoClimatica);
    }
}
