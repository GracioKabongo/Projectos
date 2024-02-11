package Vendas;
public class DadosCarrinho {
    private String produto;
    private int qtd;
    private float preco;

    public DadosCarrinho(String produto, int qtd, float preco) {
        this.produto = produto;
        this.qtd = qtd;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "DadosCarrinho{" + "produto=" + produto + ", qtd=" + qtd + ", preco=" + preco + '}';
    }
    
    
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
}
