package unitTest;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Questao02;

public class Questao02Test {

	@Test
	@DisplayName("Verifica se a resposta da função está correta")
	public void testarVerificacaoSenhaForte() {
		
		// arrange
		String resultadoEsperado = "Senha Forte!";

		// act
		String teste = Questao02.verificarSenha("D@n1el");
		
		// assert
		Assert.assertEquals(teste, resultadoEsperado);
	}
	
	@Test
	@DisplayName("Verifica se a resposta da função aponta a falta de digitos na senha")
	public void testarVerificacaoSenhaFraca() {
		
		// arrange
		String resultadoEsperado = "Senha fraca!\nInsira:\n" + "No mínimo um digito.\n";

		// act
		String teste = Questao02.verificarSenha("D@niel");
		
		// assert
		Assert.assertEquals(teste, resultadoEsperado);
	}
	
	@Test
	@DisplayName("Verifica se a resposta da função aponta a falta de caracteres na senha.")
	public void testarVerificacaoTamanhoSenha() {
		
		// arrange
		String resultadoEsperado = "Senha fraca!\nInsira 2 caracteres para ter uma senha forte;\n";

		// act
		String teste = Questao02.verificarSenha("D@n1");
		
		// assert
		Assert.assertEquals(teste, resultadoEsperado);
	}
}