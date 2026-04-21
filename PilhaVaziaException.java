public class PilhaVaziaException extends RuntimeException {
    public PilhaVaziaException() {
        super("Erro: A pilha esta vazia");
    }

    public PilhaVaziaException(String msg) {
        super(msg);
    }
}
