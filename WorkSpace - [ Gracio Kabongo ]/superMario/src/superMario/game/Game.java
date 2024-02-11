package superMario.game;

import org.newdawn.slick.*;

public class Game extends BasicGame {

    private Image player;
    private float x, y;

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        player = new Image("player.png"); // Carrega a imagem do jogador
        x = container.getWidth() / 2; // Define a posição inicial do jogador no centro da tela
        y = container.getHeight() / 2;
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        g.drawImage(player, x, y); // Desenha o jogador na tela
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        Input input = container.getInput(); // Lê as entradas do usuário

        if (input.isKeyDown(Input.KEY_LEFT)) { // Move o jogador para a esquerda
            x -= delta * 0.1f;
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) { // Move o jogador para a direita
            x += delta * 0.1f;
        }
        if (input.isKeyDown(Input.KEY_UP)) { // Move o jogador para cima
            y -= delta * 0.1f;
        }
        if (input.isKeyDown(Input.KEY_DOWN)) { // Move o jogador para baixo
            y += delta * 0.1f;
        }
    }

    public static void main(String[] args) throws SlickException {
        GameContainer container = new AppGameContainer(new Game("My Game"));
        container.setDisplayMode(640, 480, false); // Define o tamanho da janela do jogo
        container.start(); // Inicia o jogo
    }
}

