package unitTest;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Questao01;

public class Questao01Test {
	
	@Test
	@DisplayName("Verifica se a função está criando a escada corretamente")
	public void testarCriacaoEscada() {
		
		// arrange
		String resultadoEsperado = "  *\n **\n***\n";

		// act
		String teste = Questao01.gerarEscada(3);
		
		// assert
		Assert.assertEquals(teste, resultadoEsperado);
	}
}