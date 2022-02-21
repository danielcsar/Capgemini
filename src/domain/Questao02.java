package domain;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Questao02 {

	public static void main(String[] args) {

		/*
		 * Débora se inscreveu em uma rede social para se manter em contato com seus
		 * amigos. A página de cadastro exigia o preenchimento dos campos de nome e
		 * senha, porém a senha precisa ser forte. O site considera uma senha forte
		 * quando ela satisfaz os seguintes critérios: Possui no mínimo 6 caracteres.
		 * Contém no mínimo 1 digito. Contém no mínimo 1 letra em minúsculo. Contém no
		 * mínimo 1 letra em maiúsculo. Contém no mínimo 1 caractere especial. Os
		 * caracteres especiais são: !@#$%^&*()-+ Débora digitou uma string aleatória no
		 * campo de senha, porém ela não tem certeza se é uma senha forte. Para ajudar
		 * Débora, construa um algoritmo que informe qual é o número mínimo de
		 * caracteres que devem ser adicionados para uma string qualquer ser considerada
		 * segura.
		 */

		System.out.printf("Digite a senha: ");
		String senha = lerPalavra();
		System.out.println();
		System.out.println(verificarSenha(senha));
	}

	/**
	 * Método para compilar uma expressão regular e testar uma string.
	 *
	 * @param regex    Expressão regular.
	 * @param senha    String que será testada com a expressão regular.
	 * @param mensagem Mensagem de retorno.
	 * @return String Retorna uma mensagem caso a string senha não passe na
	 *         verificação da expressão regular.
	 */
	public static String testarRegex(String regex, String senha, String mensagem) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(senha);

		if (!matcher.find()) {
			return mensagem;
		}
		return "";
	}

	/**
	 * Método para verificar se uma senha possui pelo menos um número, uma letra
	 * maiúscula, uma minuscula e um caracterer especial(!@#$%^&*()-+).
	 *
	 * @param senha String que será testada.
	 * @return String Caso não tenha uma ou mais das características exigidas, o
	 *         usuário receberá uma frase do que deve ser corrigido em sua senha.
	 */
	public static String verificarRegex(String senha) {
		final String REGEX_NUM = "[0-9]";
		final String REGEX_MAI = "[A-Z]";
		final String REGEX_MIN = "[a-z]";
		final String REGEX_CAR = "[!@#$%^&*()-+]";

		String resposta = "";

		resposta += testarRegex(REGEX_NUM, senha, "No mínimo um digito.\n");
		resposta += testarRegex(REGEX_MAI, senha, "No mínimo uma letra em maiúsculo.\n");
		resposta += testarRegex(REGEX_MIN, senha, "No mínimo uma letra em minúsculo.\n");
		resposta += testarRegex(REGEX_CAR, senha, "No mínimo um caractere especial.\n");

		return resposta;
	}

	/**
	 * Método para verificar quantos caracteres faltam para uma string ter 6
	 * caracteres de comprimento.
	 *
	 * @param senha String que será testada.
	 * @return Integer retorna a quantidade.
	 */
	public static Integer verificarTamanho(String senha) {
		Integer response = 0;

		if (senha.length() < 6) {
			Integer sen = 6 - senha.length();
			response = sen;
		}
		return response;
	}

	/**
	 * Método para verificar se uma senha é forte utilizando expressões regulares e
	 * caracteres mínimos.
	 *
	 * @param senha String que será testada.
	 * @return String retorna uma frase como resultado do teste.
	 */
	public static String verificarSenha(String senha) {
		Integer tamanho = verificarTamanho(senha);
		String regex = verificarRegex(senha);
		String resposta = "";

		if (tamanho.equals(0) && regex.equals("")) {
			resposta = "Senha Forte!";
		} else if (tamanho == 0 && !regex.equals("")) {
			resposta = "Senha fraca!\nInsira:\n";
			resposta += regex;
		} else {
			resposta = String.format("Senha fraca!\nInsira %s caracteres para ter uma senha forte;\n", tamanho);
			resposta += regex;
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