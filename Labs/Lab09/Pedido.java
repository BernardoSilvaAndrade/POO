import java.util.ArrayList;

public class Pedido {
    private int codigoPedido;
    private String clienteNome;
    private ArrayList<Produto> itens;
    private double total;

    public Pedido() {
        this.codigoPedido = 0;
        this.itens = new ArrayList<Produto>();
        this.total = 0;
    }

    public Pedido(int codigoPedido, String clienteNome) {
        this.codigoPedido = codigoPedido;
        this.clienteNome = clienteNome;
        this.itens = new ArrayList<Produto>();
        this.total = 0;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produto.getEstoque() >= quantidade) {
            produto.reduzirEstoque(quantidade);
            itens.add(produto);
        } else {
            throw new IllegalArgumentException("Estoque insuficiente para " + produto.getDescricao());
        }
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }

    @Override
    public String toString() {
        return "Pedidos:\nNome do cliente: " + clienteNome + "\nItens: " + itens;
    }
}
