public class Caminhao extends Veiculo {
    protected double capacidadeCarga;

    public Caminhao(double capacidadeCarga, String placa, String modelo) {
        super(placa, modelo);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double gatCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + ", Capacidade de Carga: " + capacidadeCarga;
    }

    public double calcularCusto(double distancia) {
        return distancia * 1;
    }
} 
