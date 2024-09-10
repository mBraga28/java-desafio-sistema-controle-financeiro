package mv.atividade.client_finance_control.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mv.atividade.client_finance_control.entities.Conta;
import mv.atividade.client_finance_control.entities.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{
    List<Movimentacao> findByConta(Conta conta);

    List<Movimentacao> findByClienteIdAndDataBetween(Long idCliente, Date dataInicial, Date dataFinal);

    List<Movimentacao> findByClienteIdAndDataBefore(Long id, Date dataInicial);

    List<Movimentacao> findByClienteIdAndDataBefore(Long id, java.util.Date dataInicial);

    List<Movimentacao> findByClienteIdAndDataBetween(Long idCliente, java.util.Date dataInicial,
            java.util.Date dataFinal);

    Optional<Movimentacao> findByDataBetween(java.util.Date dataInicial, java.util.Date dataFinal);
}
