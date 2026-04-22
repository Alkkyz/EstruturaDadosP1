public class PilhaPrioridade {
    private PilhaProcesso pilhaBaixa;
    private PilhaProcesso pilhaNormal;
    private PilhaProcesso pilhaUrgente;

    public PilhaPrioridade(){
        this.pilhaBaixa = new PilhaProcesso();
        this.pilhaNormal = new PilhaProcesso();
        this.pilhaUrgente = new PilhaProcesso();
    }

    public void push (Processo processo) {
        int prioridade = processo.getPrioridade();

        switch (prioridade) {
            case 1:
                pilhaBaixa.push(processo);
                System.out.println("Processo de prioridade BAIXA adicionado");
                break;
            case 2: 
                pilhaNormal.push(processo);
                System.out.println("processo de prioridade NORMAL adicionado");
                break;
            case 3:
                pilhaUrgente.push(processo);
                System.out.println("Processo de prioridade URGENTE adicionado");
                break;
            default:
                System.out.println("Prioridade Invalida - Usando NORMAL");
                pilhaNormal.push(processo);
        }
    }

    public Processo pop() {
        if (!pilhaUrgente.isEmpty()) {
            System.out.println("Atendendo processo - URGENTE");
            return pilhaUrgente.pop();
        } else if (!pilhaNormal.isEmpty()) {
            System.out.println("Atendendo processo - NORMAL");
            return pilhaNormal.pop();
        } else if (!pilhaBaixa.isEmpty()) {
            System.out.println("Atendendo processo - BAIXO");
            return pilhaBaixa.pop();
        } else {
            throw new PilhaVaziaException("Não há processos");
        }
    }

    public Processo topo() {
        if (!pilhaUrgente.isEmpty()){
            return pilhaUrgente.topo();
        } else if (!pilhaNormal.isEmpty()){
            return pilhaNormal.topo();
        } else if (!pilhaBaixa.isEmpty()){
            return pilhaBaixa.topo();
        } else{
            throw new PilhaVaziaException("Não há processos");
        }
    }

    public int tamanho(){
        return pilhaBaixa.tamanho() + pilhaNormal.tamanho() + pilhaUrgente.tamanho();
    }

    public boolean isEmpty() {
        return pilhaBaixa.isEmpty() && pilhaNormal.isEmpty() && pilhaUrgente.isEmpty();
    }

    public void listar(){
        System.out.println("-- Processo por Prioridade --");
        
        System.out.println("-- URGENTE - prioridade 3 --");
        if (pilhaUrgente.isEmpty()){
            System.out.println("Nenhum processo urgente");
        } else {
            VetorDinamico vetor = pilhaUrgente.getVetor();
            for (int i = 0; i < vetor.getTamanho(); i++) {
                System.out.println(" " + (i + 1) + " - " + vetor.get(i));
            }
        }

        System.out.println("-- NORMAL - prioridade 2 --");
        if (pilhaNormal.isEmpty()) {
            System.out.println("Nenhum processo normal");
        } else{
            VetorDinamico vetor = pilhaNormal.getVetor();
            for(int i = 0; i < vetor.getTamanho(); i++) {
                System.out.println(" " + (i + 1) + " - " + vetor.get(i));
            }
        }

        System.out.println("-- BAIXO - prioridade 1 --");
        if(pilhaBaixa.isEmpty()) {
            System.out.println("Nenhum processo baixo");
        } else {
            VetorDinamico vetor = pilhaBaixa.getVetor();
            for (int i = 0; i < vetor.getTamanho(); i++){
                System.out.println(" " + (i + 1) + " - " + vetor.get(i));
            }
        }
        System.out.println("\nTotal de Processos: " + tamanho());
    }

    public void limpar() {
        System.out.println("-- limpando as pilhas de prioridade --");
        pilhaUrgente.limpar();
        pilhaNormal.limpar();
        pilhaBaixa.limpar();
    }

    public boolean hasUrgente() {
        return !pilhaUrgente.isEmpty();
    }
    public boolean hasNormal(){
        return !pilhaNormal.isEmpty();
    }
    public boolean hasBaixa(){
        return pilhaBaixa.isEmpty();
    }

}
