package mv.atividade.client_finance_control.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RelatorioReceitaDTO {

    private String periodo;
    private List<RelatorioClienteDTO> clientes = new ArrayList<>();
    private BigDecimal receitaTotal;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<RelatorioClienteDTO> getClientes() {
        return clientes;
    }
    
    public BigDecimal getReceitaTotal() {
        return receitaTotal;
    }

    public void setReceitaTotal(BigDecimal receitaTotal) {
        this.receitaTotal = receitaTotal;
    }


    
}
