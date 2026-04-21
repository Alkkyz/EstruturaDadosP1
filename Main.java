import java.util.Scanner;

public class Main {
    private static CentralAtendimento central = new CentralAtendimento();
    private static Scanner scan = new Scanner(System.in);
    private static int contadorProtocolo = 1;

    public static void main (String[] args) {
        System.out.println("-- Central de Atendimento --\n");
        int opcao;
        do { 
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("\n-- Sistema Encerrado --");
        scan.close();
    }

    private static void exibirMenu() {
        System.out.println("-- MENU PRINCIPAL --");
        System.out.println("1 - Abrir novo processo");
        System.out.println("2 - Atender próximo processo");
        System.out.println("3 - Desfazer ultimo processo");
        System.out.println("4 - Listar processos pendentes");
        System.out.println("5 - Listar histórico de atendimento");
        System.out.println("0 - Sair");
        System.out.println("Digite sua Opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                abrirProcesso();
                break;
            case 2:
                try {
                    central.atenderProximo();
                } catch (PilhaVaziaException e) {
                    System.out.println("Erro: "+ e.getMessage());
                }
                break;
            case 3:
                try {
                    central.desfazerUltimoAtendimento();
                } catch (PilhaVaziaException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                break;
            case 4:
                central.listarPendentes();
                break;
            case 5:
                central.listarHistorico();
                break;
            case 0:
                System.out.println("-- Encerrando --");
                break;
            default:
                System.out.println("Opção inválida - Tente novamente");
        }
    }
    
    private static void abrirProcesso() {
        System.out.println("\n--- Novo Processo ---");
        
        System.out.print("Nome do solicitante: ");
        String solicitante = scan.nextLine();
        
        System.out.print("Tipo de serviço: ");
        String tipoServico = scan.nextLine();
        
        System.out.print("Prioridade (1-Baixa, 2-Normal, 3-Urgente): ");
        int prioridade;
        try {
            prioridade = Integer.parseInt(scan.nextLine());
            if (prioridade < 1 || prioridade > 3) {
                System.out.println("Prioridade inválida - Usando Normal (2).");
                prioridade = 2;
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido - Usando Normal (2).");
            prioridade = 2;
        }
        
        Processo novoProcesso = new Processo(solicitante, tipoServico, prioridade);
        central.abrirProcesso(novoProcesso);
    }
}
