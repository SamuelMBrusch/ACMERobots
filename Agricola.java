package data;

public class Agricola extends Robo{
    private double area;
    private String uso;

    public Agricola(int id, String modelo, double valorDiario, double area, String uso) {
        super(id, modelo, valorDiario);
        this.area = area;
        this.uso = uso;
    }

    public double calculaLocacao(int dias){
        return dias * area * 10;
    }

}
