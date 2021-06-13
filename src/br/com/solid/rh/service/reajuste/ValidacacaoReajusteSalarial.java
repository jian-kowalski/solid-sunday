package br.com.solid.rh.service.reajuste;

import java.math.BigDecimal;

import br.com.solid.rh.model.Funcionario;

public interface ValidacacaoReajusteSalarial {

    void validar(Funcionario funcionario, BigDecimal valorAumento);

}
