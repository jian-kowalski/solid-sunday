package br.com.solid.rh.service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.solid.rh.exception.ValidacaoException;
import br.com.solid.rh.model.Funcionario;

public class ValidacaoPercentualReajuste implements ValidacacaoReajusteSalarial {

    public void validar(Funcionario funcionario, BigDecimal valorAumento){
        var salarioAtual = funcionario.getSalario();
        var percentualReajuste = valorAumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
    }
    
}
