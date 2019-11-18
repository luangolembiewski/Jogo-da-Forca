package jogo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoForca {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		Random aleatorio = new Random();
		ArrayList palavrasPasta = new ArrayList<String>();
		ArrayList palavras = new ArrayList<String>();
		ArrayList<String> dados = new ArrayList();
		String continuar = "sim";
		int round = 0;

		palavrasPasta.add("m e l a n c i a".toUpperCase());
		palavrasPasta.add("a b a c a x i".toUpperCase());
		palavrasPasta.add("b a n a n a".toUpperCase());
		palavrasPasta.add("p i t a y a".toUpperCase());
		palavrasPasta.add("m a r a c u j a".toUpperCase());
		palavrasPasta.add("a b a c a t e".toUpperCase());
		palavrasPasta.add("t a n g e r i n a".toUpperCase());
		palavrasPasta.add("l i c h i a".toUpperCase());

		
		try {
			FileWriter outputStream = new FileWriter("D:/Palavras(Jogo da forca).txt"); // abre
			PrintWriter arquivoSaida = new PrintWriter(outputStream);
			
			for (int i = 0; i < palavrasPasta.size(); i++) {
				arquivoSaida.println(palavrasPasta.get(i));
			}

			arquivoSaida.close();
			outputStream.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		while (continuar.equals("sim")) {

			round = round + 1;

			int valor = 0;
			int acerto = 0;
			int erro = 0;
			String letra = "";
			String letrasDigitadas = "";
			String posicaoLetra = "";
			String barrinha = "";
			int j = 0;
			String jogador = "";
			String resultado = "";

			try {
				FileReader inputStream = new FileReader("D:/Palavras(Jogo da forca).txt"); // abre a pasta
				BufferedReader arquivoEntrada = new BufferedReader(inputStream);

				String linha;
				while ((linha = arquivoEntrada.readLine()) != null) { // adiciona as palavras
					palavras.add(linha);
				}
				arquivoEntrada.close();
				inputStream.close(); // fecha a pasta
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			valor = aleatorio.nextInt(8); // escolhe um numero aleatório entre 0 e 7
			String palavra = (String) (palavras.get(valor)); // escolhe uma palavra aleatória entre 8

			String[] palavraArray = palavra.split(" ");

			for (int a = 0; a < palavraArray.length; a++) {
				barrinha = barrinha + "_ ";

			}

			System.out.println("|=====================================================|");
			System.out.println("|=====FFFFF=====OOOO===RRRRRR=====CCCCC======AAAA=====|");
			System.out.println("|====FF========O====O==RR===RR===CC=========AA==AA====|");
			System.out.println("|====FFFFF=====O====O==RR=RRR====CC=========AAAAAA====|");
			System.out.println("|====FF======= O====O==RR==RR====CC========AA====AA===|");
			System.out.println("|====FF======= O====O==RR===RR===CC========AA====AA===|");
			System.out.println("|====FF=========OOOO===RR====RR===CCCCC====AA====AA===|");
			System.out.println("|=====================================================|");

			System.out.println("             Aperte 'Enter' para iniciar");
			leia.nextLine();

			System.out.println("Qual o nome do jogador:");
			jogador = leia.nextLine();

			System.out.println("________________               ");
			System.out.println("|                              ");
			System.out.println("|                  Dica: fruta ");
			System.out.println("|                              ");
			System.out.println("|                              ");
			System.out.println("|" + barrinha);

			while ((acerto < palavraArray.length) && (erro < 6)) {
				System.out.println("Digite uma letra");
				letra = leia.next();
				System.out.println("===============================================");

				while (letrasDigitadas.contains(letra)) {
					System.out.println("Letra repetida!");
					System.out.println("Digite novamente:");
					letra = leia.next();
				}
				letra = letra.toUpperCase();
				letrasDigitadas = letrasDigitadas + ". " + letra;
				posicaoLetra = "";
				List<Integer> posicaoLetraInt = new ArrayList<Integer>();
				for (j = 0; j < palavraArray.length; j++) {
					if (palavraArray[j].equals(letra)) {
						int x = 0;
						posicaoLetraInt.add(x, j);
						x = x++;
						acerto = acerto + 1;
					}
				}

				if (!palavra.contains(letra)) {
					erro = erro + 1;
					System.out.println("LETRA INEXISTENTE!!");
				} else if (letrasDigitadas.contains(letra)) {
					System.out.println("CONTEM!!");
				}

				for (int c = 0; c < posicaoLetraInt.size(); c++) {
					int inicio = (posicaoLetraInt.get(c) * 2);
					barrinha = barrinha.substring(0, inicio) + letra
							+ barrinha.substring((inicio + 1), barrinha.length());
				}

				switch (erro) {
				case 0:
					System.out.println("________________      letras digitadas:  ");
					System.out.println("|                     " + letrasDigitadas);
					System.out.println("|                                        ");
					System.out.println("|                     Dica: fruta        ");
					System.out.println("|                                        ");
					System.out.println("|" + barrinha);

					break;
				case 1:
					System.out.println("________________      letras digitadas:  ");
					System.out.println("|               O     " + letrasDigitadas);
					System.out.println("|                                        ");
					System.out.println("|                     Dica: fruta        ");
					System.out.println("|                                        ");
					System.out.println("|" + barrinha);

					break;
				case 2:
					System.out.println("________________      letras digitadas:  ");
					System.out.println("|               O     " + letrasDigitadas);
					System.out.println("|               |                        ");
					System.out.println("|                     Dica: fruta        ");
					System.out.println("|                           ");
					System.out.println("|" + barrinha);

					break;
				case 3:
					System.out.println("________________      letras digitadas:   ");
					System.out.println("|               O     " + letrasDigitadas);
					System.out.println("|              /|                         ");
					System.out.println("|                     Dica: fruta         ");
					System.out.println("|                           ");
					System.out.println("|" + barrinha);

					break;
				case 4:
					System.out.println("________________      letras digitadas:   ");
					System.out.println("|               O     " + letrasDigitadas);
					System.out.println("|              /|\\                       ");
					System.out.println("|                     Dica: fruta         ");
					System.out.println("|                                         ");
					System.out.println("|" + barrinha);

					break;
				case 5:
					System.out.println("________________      letras digitadas:   ");
					System.out.println("|               O     " + letrasDigitadas);
					System.out.println("|              /|\\                       ");
					System.out.println("|              /      Dica: fruta         ");
					System.out.println("|                                         ");
					System.out.println("|" + barrinha);
					break;
				}

			}
			if (erro == 6) {
				System.out.println("VOCE PERDEU, TENTE NOVAMENTE!!         ");
				System.out.println("________________                       ");
				System.out.println("|               O                      ");
				System.out.println("|              /|\\      Dica: fruta   ");
				System.out.println("|              / \\                    ");
				System.out.println("|");
				System.out.println("|" + palavra);
				resultado = ("PERDEU");
			} else if (acerto == palavraArray.length) {
				System.out.println("======================================");
				System.out.println("    PARABÉNS " + jogador.toUpperCase() + ", VOCÊ GANHOU!!");
				resultado = ("GANHOU");
			}
			System.out.println("======================================");
			System.out.println("Deseja jogar novamente? (sim/nao)");
			leia.nextLine();
			continuar = leia.nextLine();
			continuar = continuar.toLowerCase();

			dados.add ("Round: " + round + " {Jogador: " + jogador + "; " + resultado + " ; Palavra: " + palavra + "}");

		}
		try {
			FileWriter outputStream = new FileWriter("D:/jogadas(Jogo da forca).txt"); // abre
			PrintWriter arquivoSaida = new PrintWriter(outputStream);

			for (int i = 0; i < dados.size(); i++) {
				arquivoSaida.println(dados.get(i));
			}

			arquivoSaida.close();
			outputStream.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("======================================");

		try {
			FileReader inputStream = new FileReader("D:/jogadas(Jogo da forca).txt"); // abre a pasta
			BufferedReader arquivoEntrada = new BufferedReader(inputStream);

			String linha;
			while ((linha = arquivoEntrada.readLine()) != null) {
				System.out.println(linha);
			}

			arquivoEntrada.close();
			inputStream.close(); // fecha a pasta
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("======================================");
		System.out.println("Deseja deletar os dados do sistema? (sim/nao)");
		String delArquivos = leia.nextLine();
		delArquivos = delArquivos.toLowerCase();

		if (delArquivos.equals("sim")) {
			try {
				File jogadas = new File("D:/jogadas(Jogo da forca).txt"); // abre a pasta
				File arquivoPalavras = new File("D:/Palavras(Jogo da forca).txt");

				if (jogadas.delete() && (arquivoPalavras.delete())) {
					System.out.println(jogadas.getName() + " removido com sucesso!");
					System.out.println(arquivoPalavras.getName() + " removido com sucesso!");
				} else {
					System.out.println("Erro na remoção!");
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {
			System.out.println("Os arquivos foram mantidos!");
		}
		System.out.println("======================================");
		System.out.println("            FIM DO JOGO!!");

	}

}
