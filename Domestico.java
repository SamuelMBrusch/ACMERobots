package data;

public class Domestico extends Robo{
    private int nivel;

    public Domestico(int id, String modelo, double valorDiario){
        super(id, modelo, valorDiario);
        this.nivel = nivel;
    }
    public int getNivel(){
        return nivel;
    }

    public double calculaLocacao(int dias){
        double valorPorDia = 0.0;
        switch (nivel) {
            case 1:
                valorPorDia = 10.0;
                break;
            case 2:
                valorPorDia = 20.0;
                break;
            case 3:
                valorPorDia = 50.0;
                break;
            default:
                throw new IllegalArgumentException("Nível inválido para robô doméstico");
        }
        return valorPorDia * dias;
    }

}
