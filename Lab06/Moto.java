public class Moto extends Veiculo {
    protected int cilindradas;

    public Moto(int cilindradas, String placa, String modelo) {
        super(placa, modelo);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getDetalhes() {
        return super.getDetalhes() + ", Cilindradas: " + cilindradas;
    }

    public double calcularCusto(double distancia) {
        return distancia * 0.2;
    }
}
