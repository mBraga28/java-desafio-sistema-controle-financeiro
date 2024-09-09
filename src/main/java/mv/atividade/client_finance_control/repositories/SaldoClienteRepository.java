package mv.atividade.client_finance_control.repositories;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;

public interface SaldoClienteRepository {

    @Query("SELECT SUM(m.valor) FROM Movimentacao m WHERE m.cliente.id = :idCliente AND m.data BETWEEN :dataInicio AND :dataFinal")
    BigDecimal calcularSaldoClientePeriodo(Long idCliente, Date dataInicial, Date dataFinal);
}
