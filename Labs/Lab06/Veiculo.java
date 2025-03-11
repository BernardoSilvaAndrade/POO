public class Veiculo {
    protected String placa;
    protected String modelo;

    public Veiculo() {
    }

    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDetalhes() {
        return "Placa: " + placa + ", Modelo: " + modelo;
    }

    public double calcularCusto(double distancia) {
        return 0;
    }
}
