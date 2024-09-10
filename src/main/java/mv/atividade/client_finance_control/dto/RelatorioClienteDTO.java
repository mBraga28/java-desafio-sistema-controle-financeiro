package mv.atividade.client_finance_control.dto;

import java.math.BigDecimal;

public class RelatorioClienteDTO {

    private Long clienteId;
    private int quantidadeMovimentacoes;
    private BigDecimal valorTotal;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public int getQuantidadeMovimentacoes() {
        return quantidadeMovimentacoes;
    }

    public void setQuantidadeMovimentacoes(int quantidadeMovimentacoes) {
        this.quantidadeMovimentacoes = quantidadeMovimentacoes;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

}
