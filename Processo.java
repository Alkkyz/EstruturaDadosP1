public class Processo {
    private int protocolo;
    private int prioridade;
    private String solicitante;
    private String tipoServico;
    private String dataHora;

    public Processo(String solicitante, String tipoServico, int prioridade) {
        this.protocolo = protocolo++;
        this.solicitante = solicitante;
        this.tipoServico = tipoServico;
        this.prioridade = prioridade;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public int getPrioridade(){
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getSolicitante(){
        return solicitante;
    }
    
    public void setSolicitante(String solicitante){
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
