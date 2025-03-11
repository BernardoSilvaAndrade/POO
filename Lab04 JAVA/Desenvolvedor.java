public class Desenvolvedor extends Funcionario implements InterfaceDesenvolvedor {
    private String linguagemPrincipal;

    public Desenvolvedor(String nome, double salarioBase, String linguagemPrincipal) {
        super(nome, salarioBase);
        this.linguagemPrincipal = linguagemPrincipal;
    }

    public String getLinguagemPrincipal() {
        return linguagemPrincipal;
    }

    public void setLinguagemPrincipal(String linguagemPrincipal) {
        this.linguagemPrincipal = linguagemPrincipal;
    }

    public String projetosRealizados() {
        return "Projetos entregues na linguagem " + linguagemPrincipal;
    }
    
    @Override
    public String descricao() {
    return super.descricao() + ", Linguagem principal: " + linguagemPrincipal;
}
}
