public class CentralAtendimento {
    private PilhaPrioridade pilhaPrincipal;
    private PilhaProcesso pilhaSecundaria;

    public CentralAtendimento() {
        this.pilhaPrincipal = new PilhaPrioridade();
        this.pilhaSecundaria = new PilhaProcesso();
    }

    public void abrirProcesso(Processo processo) {
        System.out.println("-- Novo Processo --");
        pilhaPrincipal.push(processo);

        if (!pilhaSecundaria.isEmpty()) {
            System.out.println("-- Eliminando histórico --");
            pilhaSecundaria.limpar();
        }

        System.out.println("-- Novo Processo Aberto com Sucesso --");
    }

    public void atenderProximo() {
        System.out.println("-- Atendendo Novo Processo --");

        if (pilhaPrincipal.isEmpty()) {
            System.out.println("-- Não há processos pendentes --");
            return;
        }

        Processo finalizado = pilhaPrincipal.pop();
        pilhaSecundaria.push(finalizado);
        System.out.println("Processo finalizado com sucesso");
    }

    public void desfazerUltimoAtendimento() {
        System.out.println("-- Desfazendo Último Processo --");

        if (pilhaSecundaria.isEmpty()) {
            System.out.println("-- Não há processos no histórico --");
            return;
        }
        Processo desfazer = pilhaSecundaria.pop();
        pilhaPrincipal.push(desfazer);
        System.out.println("-- Processo retornou à fila de pendentes --");
    }

    public void listarPendentes() {
        System.out.println("-- Processos Pendentes --");

        if (pilhaPrincipal.isEmpty()) {
            System.out.println("-- Nenhum Processo Pendente --");
            return;
        }
        pilhaPrincipal.listar();
    }

    public void listarHistorico() {
        System.out.println("-- Histórico de Atendimentos --");

        if (pilhaSecundaria.isEmpty()) {
            System.out.println("-- Nenhum atendimento realizado --");
            return;
        }

        System.out.println("-- Processos já atendidos --");
        VetorDinamico vetor = pilhaSecundaria.getVetor();
        for (int i = vetor.getTamanho() - 1; i >= 0; i--) {
            Processo p = vetor.get(i);
            System.out.println((vetor.getTamanho() - i) + " - " + p);
        }
        System.out.println("Total Atendido: " + vetor.getTamanho() + "\n");
    }
    public void mostrarStatus() {

        System.out.println("-- Status do Sistema --");
        System.out.println("Processos pendentes: " + pilhaPrincipal.tamanho());
        System.out.println("Processos atendidos: " + pilhaSecundaria.tamanho());
    }
}
