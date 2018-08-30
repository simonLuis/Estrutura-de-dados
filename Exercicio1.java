import javax.swing.*;

public class Exercicio1 {
	static int n = 0;
	static final int TAMANHO = 100;
	static int Lista[] = new int[TAMANHO];

	public static void CriarLista() {
			Lista[n] = Integer.parseInt(JOptionPane.showInputDialog(" Escreva o nome para a posição: " + n));
			n = n + 1;
	}

	public static String InserirInicio(int numeroInicio) {
		if(n != 0){
			n = n + 1;
			for (int i = n; i > 0; i--) {
				Lista[i] = Lista[i - 1];
			}
			Lista[0] = numeroInicio;
			return " Novo nome foi inserido na primeira posição!";
		}else{ 
			return " Lista vazia!";
		}
	}

	public static void InserirFim() {
		if (n < TAMANHO) {
			Lista[n] = Integer.parseInt(JOptionPane.showInputDialog(" Escreva o nome para a posição: " + n));
			n = n + 1;
		} else {
			JOptionPane.showMessageDialog(null, " Lista cheia!");
		}
	}

	public static void QualquerPosicao(int posicaoEspecifica) {
		n = n + 1;
		for (int i = n; i > posicaoEspecifica; i--) {
			Lista[i] = Lista[i - 1];
		}
		int novoNumero = Integer.parseInt(JOptionPane.showInputDialog(""
		+ "Informe o novo número da posição " + posicaoEspecifica));
		Lista[posicaoEspecifica] = novoNumero;
	}

	public static void RemoverFinal() {
		if (n != 0) {
			n = n - 1;
		} else {
			JOptionPane.showMessageDialog(null, " Nenhum número foi inserido!");
		}

	}

	public static boolean RemoverInicio() {
		if (n != 0) {
			for (int i = 0; i < n - 1; i++) {
				Lista[i] = Lista[i + 1];
			}
			n = n - 1;
			return true;
		} else {
			return false;
		}

	}

	public static void RemoverEspecifico(int Numero) {
		if (n != 0) {
			Lista[Numero] = Lista[Numero + 1];
			for (int i = n; i > Numero; i--) {
				Lista[i] = Lista[i + 1];
			}
			n = n - 1;
		}else{
			JOptionPane.showMessageDialog(null, " Nenhum número foi inserido! ");
		}
	}

	public static int RetornarPosicao(int Posicao) {
		
		if(n > 0){
			int i = 0;
			while((i<n) && (Lista[i]!=Posicao)){
				i = i + 1;
			}
			if(i < n){
				return i;
			}else{
				return -1;
			}
		}else{
			return -1;
		}
		
	}

	public static void MostrarNumeros() {
		String msg = " ";
		for (int i = 0; i < n; i++) {
			msg = msg + "Lista[" + i + "]: " + Lista[i] + "\n ";
		}
		JOptionPane.showMessageDialog(null, msg);
	}

	public static void main(String args[]) {

		int Menu = 1;

		while (Menu != 99) {
			Menu = Integer.parseInt(JOptionPane.showInputDialog(" Escolha uma operação: " 
			+ "\n 1- Criar e implementar números na lista: "
			+ "\n 2- Inserir novo nó no início da lista: " 
			+ "\n 3- Inserir novo nó no fim da lista: "
			+ "\n 4- Implementar um novo nó em uma posição específica da lista: "
			+ "\n 5- Remover o nó do final da lista " 
			+ "\n 6- Remover o nó do início da lista: "
			+ "\n 7- Remover o nó de uma posição específica da lista: "
			+ "\n 8- Retornar a posição de um nó da lista: " 
			+ "\n 9- Mostrar os números inseridos: "
			+ "\n 99- Sair "));
			switch (Menu) {
				case 1: {
					CriarLista();
					break;
				}

				case 2: {
					int numeroInicio = Integer.parseInt(JOptionPane.showInputDialog(""
					+" Digite o novo número da primeira posição: "));
					String numeroInicial = InserirInicio(numeroInicio);
					JOptionPane.showMessageDialog(null, numeroInicial);
					break;
				}

				case 3: {
					InserirFim();
					break;
				}

				case 4: {
					int posicaoEspecifica = Integer.parseInt(JOptionPane.showInputDialog(""
					+" A Lista tem " + n + " posições. Em qual posição você deseja inserir o novo valor?"));
					QualquerPosicao(posicaoEspecifica);
					break;
				}

				case 5: {
					RemoverFinal();
					break;
				}

				case 6: {
					if(RemoverInicio() == true){
						JOptionPane.showMessageDialog(null, " Valor da primeira posição foi removido! ");
					}else{
						JOptionPane.showMessageDialog(null, " Lista vazia! ");
					}
					break;
				}

				case 7: {
					int Numero = Integer.parseInt(JOptionPane.showInputDialog(" Digite o número que desea remover: "));
					RemoverEspecifico(Numero);
					break;
				}

				case 8: {
					
					int Posicao = Integer.parseInt(JOptionPane.showInputDialog(" Qual a posição que deseja ver? "));
					if(RetornarPosicao(Posicao)!= -1){
						JOptionPane.showMessageDialog(null, " Achei na posição "+Posicao);
					}else{
						JOptionPane.showMessageDialog(null, " Nenhum número foi inserido nesta posição! ");
					}
					break;
				}

				case 9: {
					MostrarNumeros();
					break;
				}

				default: {
					JOptionPane.showMessageDialog(null, " Operação inválida! ");
					break;
				}

				case 99: {
					System.out.println(" Saindo do programa. Até logo!");
					break;
				}
			}
		}
	}
}