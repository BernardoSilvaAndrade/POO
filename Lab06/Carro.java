public class Carro extends Veiculo {
    protected int assentos;

    public Carro(int assentos, String placa, String modelo) {
        super(placa, modelo);
        this.assentos = assentos;
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + ", Assentos: " + assentos;
    }

    public double calcularCusto(double distancia) {
        return distancia * 0.5;
    }
}
