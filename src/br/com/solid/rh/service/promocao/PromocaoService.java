package br.com.solid.rh.service.promocao;

import br.com.solid.rh.exception.ValidacaoException;
import br.com.solid.rh.model.Cargo;
import br.com.solid.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida) {
        var cargoAtual = funcionario.getCargo();
        if (Cargo.GERENTE == cargoAtual) {
            throw new ValidacaoException("Gerente não pode ser promovido");
        }

        if (metaBatida) {
            var novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("Funcionario não bateu a meta!");

        }
    }
}