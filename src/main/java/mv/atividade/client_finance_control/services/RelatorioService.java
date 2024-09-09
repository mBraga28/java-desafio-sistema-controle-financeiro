package mv.atividade.client_finance_control.services;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
    public BigDecimal calcularSaldoClientePeriodo(Long idCliente, Date dataInicio, Date dataFim) {
        String sql = "call calcular_saldo_cliente_periodo(:p_cliente_id, :p_data_inicial, :p_data_final, :p_saldo_final)";
        Map<String, Object> params = new HashMap<>();
        params.put("p_cliente_id", idCliente);
        params.put("p_data_inicial", dataInicio);
        params.put("p_data_final", dataFim);

        // Convertendo o mapa para um array de objetos (ordem importante)
        Object[] args = new Object[] {params.get("p_cliente_id"), params.get("p_data_inicial"), params.get("p_data_final")};

        // Chamando o queryForObject com os argumentos corretos
        return jdbcTemplate.queryForObject(sql, args, (rs, rowNum) -> rs.getBigDecimal("p_saldo_final"));
    }

 
    public BigDecimal calcularSaldoCliente(Long idCliente, Date dataFinal) {
        String sql = "call calcular_saldo_cliente(:p_cliente_id, :p_data_final, :p_saldo_final)";
        Map<String, Object> params = new HashMap<>();
        params.put("p_cliente_id", idCliente);
        params.put("p_data_final", dataFinal);

        Object[] args = new Object[]{params.get("p_cliente_id"), params.get("p_data_final")};

        return jdbcTemplate.queryForList(sql, args, (rs, rowNum) -> rs.getBigDecimal("p_saldo_final"));
    }
}
