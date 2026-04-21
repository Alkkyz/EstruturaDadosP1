import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Processo {
    private int protocolo;
    private int prioridade;
    private String solicitante;
    private String tipoServico;
    private String dataHora;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Processo(String solicitante, String tipoServico, int prioridade) {
        this.protocolo = protocolo++;
        this.solicitante = solicitante;
        this.tipoServico = tipoServico;
        this.prioridade = prioridade;
        this.dataHora = LocalDateTime.now().format(FORMATTER);
    }

    private String prioridadeString() {
        switch (prioridade) {
            case 1:
                return "baixa";
            case 2:
                return "médio";
            case 3:
                return "urgente";
            default:
                return "desconhecido";
        }
    }

    @Override
    public String toString() {
        return String.format("[%d] %s | %s | %s | %s", protocolo, solicitante, tipoServico, prioridadeString(),
                dataHora);
    }

    public int getProtocolo() {
        return protocolo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

}
