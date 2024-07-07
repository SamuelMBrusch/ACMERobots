package data;

public class Empresarial extends Cliente{
    private int ano;

    public Empresarial(int codigo, String nome, int ano){
        super(codigo, nome);
        this.ano = ano;
    }

    @Override
    public double calculaDesconto(int quantidadeRobos) {
        double desconto = 0.0;
        if(quantidadeRobos >= 2 || quantidadeRobos <10){
            desconto = 0.03;
        } else if(quantidadeRobos >= 10){
            desconto = 0.07;
        }
        return desconto;
    }


}
