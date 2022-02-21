package domain;

import java.util.Scanner;

public class Questao01 {

	public static void main(String[] args) {

		/*
		 * Escreva um algoritmo que mostre na tela uma escada de tamanho n utilizando o
		 * caractere * e espaços. A base e altura da escada devem ser iguais ao valor de
		 * n. A última linha não deve conter nenhum espaço.
		 */

		System.out.printf("Digite a altura da escada: ");
		Integer altura = lerNumero();
		System.out.println(gerarEscada(altura));
		;
	}

	/**
	 * Método para gerar uma string caracteres "*" em formato de escada dada uma
	 * altura.
	 *
	 * @param altura altura da escada a ser impressa.
	 */
	public static String gerarEscada(Integer altura) {
		String str = "";

		for (int i = 1; i < altura + 1; i++) {
			for (int j = 1; j < altura + 1; j++) {
				if (i + j >= altura + 1) {
					str = str.concat("*");
				} else {
					str = str.concat(" ");
				}
			}
			str = str.concat("\n");
		}

		return str;
	}

	/**
	 * Método para scannear o próximo número digitado.
	 *
	 * @return Integer retorna o número digitado.
	 */
	public static Integer lerNumero() {
		try {
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			in.close();
			return num;

		} catch (Exception e) {
			System.out.println("Digite um número válido");
			return 0;
		}
	}
}