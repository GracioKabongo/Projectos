package filme;
import filme.Filme;
public class Main {
    public static void main(String[] args) {
        DVDAluguel dvdAluguel = new DVDAluguel();

        Filme filme1 = new Filme(1, "Filme A", "Ação", 2020);
        Filme filme2 = new Filme(2, "Filme B", "Comédia", 2018);
        Filme filme3 = new Filme(3, "Filme C", "Drama", 2021);

        dvdAluguel.inserirFilme(filme1);
        dvdAluguel.inserirFilme(filme2);
        dvdAluguel.inserirFilme(filme3);

        System.out.println("Lista de filmes:");
        dvdAluguel.listarFilmes();

        System.out.println("\nAtualizar o gênero do Filme 2:");
        dvdAluguel.atualizarGenero(2, "Suspense");

        System.out.println("\nLista de filmes atualizada:");
        dvdAluguel.listarFilmes();

        System.out.println("\nRemover o Filme 1:");
        dvdAluguel.removerFilme(1);

        System.out.println("\nLista de filmes atualizada:");
        dvdAluguel.listarFilmes();

        System.out.println("\nNome do Filme no índice 1: " + dvdAluguel.getNomeFilmeByIndex(1));

        System.out.println("\nListar filmes do gênero 'Comédia':");
        dvdAluguel.listarFilmesByGenero("Comédia");

        System.out.println("\nListar filmes lançados em 2021:");
        dvdAluguel.listarFilmesByAnoLancamento(2021);
    }
}

