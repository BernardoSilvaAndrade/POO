public class Gerente extends Funcionario implements InterfaceGerente {
    private int numeroDeEquipes;

    public Gerente(String nome, double salarioBase, int numeroDeEquipes) {
        super(nome, salarioBase);
        this.numeroDeEquipes = numeroDeEquipes;
    }

    public int getNumeroDeEquipes() {
        return numeroDeEquipes;
    }

    public void setNumeroDeEquipes(int numeroDeEquipes) {
        this.numeroDeEquipes = numeroDeEquipes;
    }

    public double calcularBonus() {
        return numeroDeEquipes * 500;
    }
    
    @Override
    public String descricao() {
    return super.descricao() + ", Número de equipes: " + numeroDeEquipes +
           ", Bônus: " + calcularBonus();
}

}
