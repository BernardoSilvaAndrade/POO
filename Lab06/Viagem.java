public class Viagem {
    protected Motorista motorista;
    protected Veiculo veiculo;
    protected double distancia;

    public Viagem(Motorista motorista, Veiculo veiculo, double distancia) {
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.distancia = distancia;
    }

    public Motorista geMotorista() {
        return motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double calcularCusto() {
        return veiculo.calcularCusto(distancia);
    }

    public String getDetalhes() {
        return "Motorista: " + motorista.getDetalhes() + "\n" +
                "Veiculo: " + veiculo.getDetalhes() + "\n" +
                "Distancia: " + distancia + " km\n" +
                "Custo Total: R$ " + String.format("%.2f", calcularCusto());
    }
}
