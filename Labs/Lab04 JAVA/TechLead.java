public class TechLead extends Funcionario implements InterfaceGerente, InterfaceDesenvolvedor {
    private int numeroDeEquipes;
    private String linguagemPrincipal;
    private int projetosEmAndamento;

    public TechLead(String nome, double salarioBase, int numeroDeEquipes, String linguagemPrincipal,int projetosEmAndamento) {
        super(nome, salarioBase);
        this.numeroDeEquipes = numeroDeEquipes;
        this.linguagemPrincipal = linguagemPrincipal;
        this.projetosEmAndamento = projetosEmAndamento;
    }

    @Override
    public int getNumeroDeEquipes() {
        return numeroDeEquipes;
    }

    @Override
    public double calcularBonus() {
        return numeroDeEquipes * 500;
    }

    @Override
    public String getLinguagemPrincipal() {
        return linguagemPrincipal;
    }

    @Override
    public String projetosRealizados() {
        return "Projetos entregues na linguagem " + linguagemPrincipal;
    }

    @Override
     public String descricao() {
        return super.descricao() + ", Número de equipes: " + numeroDeEquipes +
               ", Linguagem principal: " + linguagemPrincipal +
               ", Projetos em andamento: " + projetosEmAndamento +
               ", Bônus: " + calcularBonus();
    }
}