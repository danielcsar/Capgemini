package domain;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Questao02 {

	public static void main(String[] args) {

		/*
		 * D�bora se inscreveu em uma rede social para se manter em contato com seus
		 * amigos. A p�gina de cadastro exigia o preenchimento dos campos de nome e
		 * senha, por�m a senha precisa ser forte. O site considera uma senha forte
		 * quando ela satisfaz os seguintes crit�rios: Possui no m�nimo 6 caracteres.
		 * Cont�m no m�nimo 1 digito. Cont�m no m�nimo 1 letra em min�sculo. Cont�m no
		 * m�nimo 1 letra em mai�sculo. Cont�m no m�nimo 1 caractere especial. Os
		 * caracteres especiais s�o: !@#$%^&*()-+ D�bora digitou uma string aleat�ria no
		 * campo de senha, por�m ela n�o tem certeza se � uma senha forte. Para ajudar
		 * D�bora, construa um algoritmo que informe qual � o n�mero m�nimo de
		 * caracteres que devem ser adicionados para uma string qualquer ser considerada
		 * segura.
		 */

		System.out.printf("Digite a senha: ");
		String senha = lerPalavra();
		System.out.println();
		System.out.println(verificarSenha(senha));
	}

	/**
	 * M�todo para compilar uma express�o regular e testar uma string.
	 *
	 * @param regex    Express�o regular.
	 * @param senha    String que ser� testada com a express�o regular.
	 * @param mensagem Mensagem de retorno.
	 * @return String Retorna uma mensagem caso a string senha n�o passe na
	 *         verifica��o da express�o regular.
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
	 * M�todo para verificar se uma senha possui pelo menos um n�mero, uma letra
	 * mai�scula, uma minuscula e um caracterer especial(!@#$%^&*()-+).
	 *
	 * @param senha String que ser� testada.
	 * @return String Caso n�o tenha uma ou mais das caracter�sticas exigidas, o
	 *         usu�rio receber� uma frase do que deve ser corrigido em sua senha.
	 */
	public static String verificarRegex(String senha) {
		final String REGEX_NUM = "[0-9]";
		final String REGEX_MAI = "[A-Z]";
		final String REGEX_MIN = "[a-z]";
		final String REGEX_CAR = "[!@#$%^&*()-+]";

		String resposta = "";

		resposta += testarRegex(REGEX_NUM, senha, "No m�nimo um digito.\n");
		resposta += testarRegex(REGEX_MAI, senha, "No m�nimo uma letra em mai�sculo.\n");
		resposta += testarRegex(REGEX_MIN, senha, "No m�nimo uma letra em min�sculo.\n");
		resposta += testarRegex(REGEX_CAR, senha, "No m�nimo um caractere especial.\n");

		return resposta;
	}

	/**
	 * M�todo para verificar quantos caracteres faltam para uma string ter 6
	 * caracteres de comprimento.
	 *
	 * @param senha String que ser� testada.
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
	 * M�todo para verificar se uma senha � forte utilizando express�es regulares e
	 * caracteres m�nimos.
	 *
	 * @param senha String que ser� testada.
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
	 * M�todo para scannear a pr�xima string digitada.
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
			System.out.println("Digite uma palavra v�lida");
			return null;
		}
	}
}