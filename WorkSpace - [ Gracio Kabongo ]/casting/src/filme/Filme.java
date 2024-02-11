package filme;

import java.util.Vector;

class Filme {
    private int numero;
    private String nome;
    private String genero;
    private int anoLancamento;

    public Filme(int numero, String nome, String genero, int anoLancamento) {
        this.numero = numero;
        this.nome = nome;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
}

class DVDAluguel {
    private Vector<Filme> filmes;

    public DVDAluguel() {
        filmes = new Vector<>();
    }

    public void inserirFilme(Filme filme) {
        filmes.add(filme);
    }

    public void removerFilme(int numero) {
        for (Filme filme : filmes) {
            if (filme.getNumero() == numero) {
                filmes.remove(filme);
                System.out.println("Filme " + numero + " removido com sucesso");
                return;
            }
        }
        System.out.println("Filme com número " + numero + " não encontrado");
    }

    public void atualizarGenero(int numero, String novoGenero) {
        for (Filme filme : filmes) {
            if (filme.getNumero() == numero) {
                filme.setGenero(novoGenero);
                System.out.println("Gênero do filme " + numero + " atualizado para " + novoGenero);
                return;
            }
        }
        System.out.println("Filme com número " + numero + " não encontrado");
    }

    public void listarFilmes() {
        for (Filme filme : filmes) {
            System.out.println("Filme " + filme.getNumero() + ": " + filme.getNome() + " (" + filme.getGenero() + ", " + filme.getAnoLancamento() + ")");
        }
    }

    public String getNomeFilmeByIndex(int index) {
        if (index >= 0 && index < filmes.size()) {
            return filmes.get(index).getNome();
        }
        return null;
    }

    public void listarFilmesByGenero(String genero) {
        for (Filme filme : filmes) {
            if (filme.getGenero().equalsIgnoreCase(genero)) {
                System.out.println("Filme " + filme.getNumero() + ": " + filme.getNome() + " (" + filme.getGenero() + ", " + filme.getAnoLancamento() + ")");
            }
        }
    }

    public void listarFilmesByAnoLancamento(int anoLancamento) {
        for (Filme filme : filmes) {
            if (filme.getAnoLancamento() == anoLancamento) {
                System.out.println("Filme " + filme.getNumero() + ": " + filme.getNome() + " (" + filme.getGenero() + ", " + filme.getAnoLancamento() + ")");
            }
        }
    }
}


