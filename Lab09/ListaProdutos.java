import java.util.ArrayList;

public class ListaProdutos<T extends Produto> {
    private ArrayList<T> produtos;

    public ListaProdutos() {
        this.produtos = new ArrayList<T>();
    }

    public ArrayList<T> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<T> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(T produto) {
        produtos.add(produto);
    }

    public T buscarProduto(int codigo) {
        for (T produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public void exibirProdutos() {
        for (T produto : produtos) {
            System.out.println(produto);
        }
    }

    public boolean ListaVazio() {
        return produtos.isEmpty();
    }

}
