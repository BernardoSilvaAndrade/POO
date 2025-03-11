public class Pessoa {
    private String nome;
    private String endereço;

    public Pessoa() {
    }

    public Pessoa(String n, String e) {
        nome = n;
        endereço = e;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

}
