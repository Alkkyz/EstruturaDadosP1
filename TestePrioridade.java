public class TestePrioridade {
    public static void main(String[] args) {
        System.out.println("-- TESTE PRIORIDADES --");

        CentralAtendimento central = new CentralAtendimento();

        System.out.println("1. Processos em ordem aleatória:");

        Processo p1 = new Processo("João Silva", "Saúde", 2); // Normal
        Processo p2 = new Processo("Maria Santos", "Financeiro", 1); // Baixa
        Processo p3 = new Processo("Pedro Costa", "Urgência", 3); // Urgente
        Processo p4 = new Processo("Ana Souza", "Administrativo", 2); // Normal
        Processo p5 = new Processo("Lucas Lima", "Emergência", 3); // Urgente

        central.abrirProcesso(p1);
        central.abrirProcesso(p2);
        central.abrirProcesso(p3);
        central.abrirProcesso(p4);
        central.abrirProcesso(p5);

        central.listarPendentes();

        System.out.println("2. Atendendo Processos:");

        central.atenderProximo();
        central.atenderProximo();
        central.atenderProximo();
        central.atenderProximo();
        central.atenderProximo();

        central.listarHistorico();

        System.out.println("3. Teste Desfazer:");

        central.desfazerUltimoAtendimento();
        central.listarPendentes();

        central.atenderProximo();

        System.out.println("-- FIM --");
    }
}
