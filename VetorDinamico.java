public class VetorDinamico {
    private Processo[] dados;
    private int tamanho;
    private int capacidadeInicial;

    public VetorDinamico(){
        this(4);
    }

    public VetorDinamico(int capacidadeInicial){
        this.capacidadeInicial = capacidadeInicial;
        this.dados = new Processo[capacidadeInicial];
        this.tamanho = 0; 
    }

    public void adicionar(Processo processo) {
        if (tamanho == dados.length) {
            redimensionaCresce();
        }
        dados[tamanho] = processo;
        tamanho++;
    }

    public Processo remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("indice invalido");
        }

        Processo removido = dados[indice];

        for (int i = indice; i < tamanho - 1; i++) {
            dados[i] = dados[i + 1];
        }

        dados[tamanho-1] = null;
        tamanho--;

        if (tamanho > 0 && tamanho <= dados.length / 4 && dados.length / 2 >= capacidadeInicial) {
            redimensionaDiminui();
        }

        return removido;
    }

    private void redimensionaCresce() {
        int novaCapacidade = dados.length * 2;
        Processo[] novoDados = new Processo[novaCapacidade];

        for (int i = 0; i < tamanho; i++) {
            novoDados[i] = dados[i];
        }

        dados = novoDados;
        System.out.println("Redimensionado - Capacidade atual:" + novoDados);
    }

    private void redimensionaDiminui() {
        int novaCapacidade = dados.length / 2;
        Processo[] novoDados = new Processo[novaCapacidade];

        for (int i = 0; i < tamanho; i++) {
            novoDados[i] = dados[i];
        }
        dados = novoDados;
        System.out.println("Redimensionado - Capacidade atual:" + novoDados);
    }

    public void listar(){
        if (tamanho == 0) {
            System.out.println("Nenhum processo cadastrado");
            return;
        }

        System.out.println("Lista de Processos");

        for(int i = 0; i < tamanho; i++) {
            System.out.println((i+1) + "-" + dados[i]);
        }
        System.out.println("Total:" + tamanho);
    }
}
