package mv.atividade.client_finance_control.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mv.atividade.client_finance_control.entities.Conta;
import mv.atividade.client_finance_control.entities.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{
    List<Movimentacao> findByConta(Conta conta);

}
