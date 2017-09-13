
public class Tabuleiro {

	private enum Jogada {
		X, O, VAZIO
	};

	private Jogada[][] tab = new Jogada[3][3];
	private int cont = 0;

	// Setando todas as posições da matriz como "vazio"
	public Tabuleiro() {
		for (int x = 0; x < tab.length; x++) {
			for (int y = 0; y < tab[x].length; y++) {
				tab[x][y] = Jogada.VAZIO;
			}
		}
	}

	// Mostrando as posições da matriz
	public void Mostrar() {

		for (int x = 0; x < tab.length; x++) {
			for (int y = 0; y < tab.length; y++) {
				if (tab[x][y].equals(Jogada.O) || tab[x][y].equals(Jogada.X)) {
					System.out.print(tab[x][y] + "    |");
				} else {
					System.out.print(tab[x][y] + "|");
				}
			}
			System.out.print("\n");
		}
	}

	// Setando as jogadas

	public void setJogada(int n1, int n2) {

		if (tab[n1][n2].equals(Jogada.VAZIO)) {
			if (cont % 2 == 0) {
				tab[n1][n2] = Jogada.O;
			} else {
				tab[n1][n2] = Jogada.X;
			}
			cont++;
		}
	}

	public boolean Ganhou() {

		int contLinha = 0;
		int contColuna = 0;
		int contDiagonal = 0;

		/*Laço para percorrer toda a matriz
		 * e comparar as linhas, colunas
		 * e diagonais, exibindo quem ganhou
		 * e retornando um valor booleano
		 * */
		
		for (int x = 0; x < tab.length; x++) {
			for (int y = 0; y < tab[x].length; y++) {
				if (x < 2 && y < 2) {
					if (tab[x][y].equals(tab[x][y + 1]) && tab[x][y] != Jogada.VAZIO) {
						contLinha++;
						if (contLinha == 2) {
							System.out.println(tab[x][y] + " ganhou por linha!");
							return true;
						}
					} else if (tab[x][y].equals(tab[x + 1][y]) && tab[x][y] != Jogada.VAZIO) {
						contColuna++;
						if (contColuna == 2) {
							System.out.println(tab[x][y] + " ganhou por coluna!");
							return true;
						}
					} else if (x == y) {
						if (tab[x][y].equals(tab[x + 1][y + 1]) && tab[x][y] != Jogada.VAZIO) {
							contDiagonal++;
							if (contDiagonal == 2) {
								System.out.println(tab[x][y] + " ganhou por diagonal!");
								return true;
							}
						}
					}
				}
			}
		}

		if (cont == 9) {
			return true;
		} else {
			return false;
		}

	}
}
