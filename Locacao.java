package data;

import java.util.Date;

public class Locacao {
    private int numero;
    private Status situacao;
    private String dataInicio;
    private int dataFim;

    public Locacao(int numero, Status situacao, String dataInicio, int dataFim){
        this.numero = numero;
        this.situacao = situacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getNumero(){
        return numero;
    }
    public Status getSituacao(){
        return situacao;
    }
    public String getDataInicio(){
        return dataInicio;
    }
    public int getDataFim(){
        return dataFim;
    }
}
