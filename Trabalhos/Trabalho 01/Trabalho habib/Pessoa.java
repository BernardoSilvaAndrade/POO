public class Pessoa {
    private String nome;
    private int idade;
    private String identificador;

    public Pessoa(String nome, int idade, String identificador) {
        this.nome = nome;
        this.idade = idade;
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        }
    }

    public void setId(String identificador) {
        this.identificador = identificador;
    }
}