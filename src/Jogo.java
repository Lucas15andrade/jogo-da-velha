import java.util.Scanner;

public class Jogo {

	private Scanner scan = new Scanner(System.in);
	private Tabuleiro t = new Tabuleiro();

	public void jogar() {
		do {

			t.Mostrar();
			int linha;
			int coluna;
			do {
				linha = scan.nextInt();
				coluna = scan.nextInt();
			} while (linha >= 3 || coluna >= 3);
			t.setJogada(linha, coluna);
		} while (t.Ganhou() == false);
	}
}
