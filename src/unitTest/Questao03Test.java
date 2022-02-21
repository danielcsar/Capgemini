package unitTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Questao03;

public class Questao03Test {
	
	@Test
	@DisplayName("Verifica se a função está criando a lista de substrings corretamente")
	public void testarFormarSubstringComValoresCorretos() {
		
		// arrange
		List<String> resultadoEsperado = new ArrayList<String>(Arrays.asList("o","v","o","ov","vo","ovo"));

		// act
		List<String> teste = Questao03.criarSubstrings("ovo");
		
		// assert
		Assert.assertEquals(teste, resultadoEsperado);
	}
	
	@Test
	@DisplayName("Verifica se a função está retornando as substrings que são anagramas e estão duplicadas")
	public void testarDuplicidadeAnagramas() {
		
		// arrange
		List<String> resultadoEsperado = new ArrayList<String>(Arrays.asList("ov", "o"));

		// act
		Set<String> teste = Questao03.verificarDuplicidadeAnagramas(Questao03.criarSubstrings("ovo"));
		
		// assert
		Assert.assertEquals(new ArrayList<>(teste), resultadoEsperado);
	}
}
