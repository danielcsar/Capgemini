package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Questao03 {

	public static void main(String[] args) {

		/*
		 * Duas palavras podem ser consideradas anagramas de si mesmas se as letras de
		 * uma palavra podem ser realocadas para formar a outra palavra. Dada uma string
		 * qualquer, desenvolva um algoritmo que encontre o número de pares de
		 * substrings que são anagramas.
		 */

		System.out.printf("Digite a palavra que deseja testar: ");
		String palavra = lerPalavra();
		System.out.println();
		System.out.println("Anagramas duplicados: " + verificarDuplicidadeAnagramas(criarSubstrings(palavra)));
		System.out.println("Total de anagramas duplicados: " + verificarDuplicidadeAnagramas(criarSubstrings(palavra)).size());

	}

	/**
	 * Método para criar substring de uma string.
	 *
	 * @param palavra string que será separada em substrings.
	 * @return List lista com todas das substrings da palavra fornecida.
	 */
	public static List<String> criarSubstrings(String palavra) {
		List<String> lista = new ArrayList<>();

		for (int i = 1; i <= palavra.length(); i++) {
			for (int j = 0; j <= palavra.length() - i; j++) {
				lista.add(palavra.substring(j, j + i));
			}
		}
		return lista;
	}

	/**
	 * Método para verificar duplicidade de anagramas em uma lista de strings.
	 *
	 * @param lista lista com substrings que serão testadas.
	 * @return Set lista com todos os anagramas duplicados.
	 */
	public static Set<String> verificarDuplicidadeAnagramas(List<String> lista) {
		Set<String> resposta = new HashSet<>();

		for (int h = 0; h < lista.size(); h++) {
			if (lista.get(h).length() == 1) {
				if (Collections.frequency(lista, lista.get(h)) > 1) {
					resposta.add(lista.get(h));
				}
				continue;
			}

			char[] array = lista.get(h).toCharArray();
			Arrays.sort(array);

			for (int i = h; i < lista.size(); i++) {

				if (lista.get(i).length() != array.length || h == i) {
					continue;
				}

				char[] array2 = lista.get(i).toCharArray();
				Arrays.sort(array2);

				if (Arrays.equals(array, array2)) {
					resposta.add(lista.get(h));
				}
			}
		}
		return resposta;
	}

	/**
	 * Método para scannear a próxima string digitada.
	 *
	 * @return String retorna a string digitada.
	 */
	public static String lerPalavra() {
		try {
			Scanner in = new Scanner(System.in);
			String num = in.nextLine();
			in.close();
			return num;

		} catch (Exception e) {
			System.out.println("Digite uma palavra válida");
			return null;
		}
	}
}