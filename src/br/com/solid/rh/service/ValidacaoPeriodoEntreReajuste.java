package br.com.solid.rh.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.solid.rh.exception.ValidacaoException;
import br.com.solid.rh.model.Funcionario;

public class ValidacaoPeriodoEntreReajuste implements ValidacacaoReajusteSalarial {

    public void validar(Funcionario funcionario, BigDecimal valorAumento){
        var dataUltReajuste  = funcionario.getDataUltimoReajuste();
        var dataAtual = LocalDate.now();
        var mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltReajuste, dataAtual);
        if (mesesDesdeUltimoReajuste < 6) {
			throw new ValidacaoException("Intervalo entre reajustes deve ser de no minimo 6 meses!");
		}
    }
    
}
