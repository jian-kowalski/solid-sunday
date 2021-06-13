package br.com.solid.rh.service.reajuste;

import java.math.BigDecimal;
import java.util.List;

import br.com.solid.rh.model.Funcionario;

public class ReajusteService {

    private List<ValidacacaoReajusteSalarial> validacoes;
    
    public ReajusteService(List<ValidacacaoReajusteSalarial> validacoes) {
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal valorAumento){
        this.validacoes.forEach(validacao -> validacao.validar(funcionario, valorAumento));

        var salarioReajustado = funcionario.getSalario().add(valorAumento);
		funcionario.atualizarSalario(salarioReajustado);

    }
    
}
