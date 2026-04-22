public class PilhaProcesso {
    private VetorDinamico vetor;

    public PilhaProcesso() {
        this.vetor = new VetorDinamico();
    }

    public boolean isEmpty() {
        return vetor.isEmpty();
    }

    public void push(Processo processo) {
        vetor.adicionar(processo);
        System.out.println("Foi empilhado: " + processo);
    }

    public Processo pop() {
        if (isEmpty()) {
            throw new PilhaVaziaException();
        }
        int topo = vetor.getTamanho() - 1;
        Processo removido = vetor.remover(topo);
        System.out.println("Foi desempilhado:" + removido);
        return removido;
    }

    public Processo topo() {
        if (isEmpty()) {
            throw new PilhaVaziaException();
        }
        int topo = vetor.getTamanho() - 1;
        return vetor.get(topo);
    }

    public void limpar() {
        while (!isEmpty()) {
            pop();
        }
        System.out.println("-- A pilha foi limpa --");
    }

    public VetorDinamico getVetor() {
        return vetor;
    }

    public int tamanho() {
        return vetor.getTamanho();
    }
}