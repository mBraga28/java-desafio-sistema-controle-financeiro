package mv.atividade.client_finance_control.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class RelatorioSaldoClienteDTO {
    
    private Long idCliente;
    private String nomeCliente;
    private EnderecoDTO endereco;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;

    private Integer movimentacoesCredito;
    private Integer movimentacoesDebito;
    private Integer totalMovimentacoes;
    private BigDecimal valorPago;
    private BigDecimal saldoInicial;
    private BigDecimal saldoAtual;

    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }
    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
   
    public EnderecoDTO getEndereco() {
        return endereco;
    }
    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
    public Integer getMovimentacoesCredito() {
        return movimentacoesCredito;
    }
    public void setMovimentacoesCredito(Integer movimentacoesCredito) {
        this.movimentacoesCredito = movimentacoesCredito;
    }
    public Integer getMovimentacoesDebito() {
        return movimentacoesDebito;
    }
    public void setMovimentacoesDebito(Integer movimentacoesDebito) {
        this.movimentacoesDebito = movimentacoesDebito;
    }
    public Integer getTotalMovimentacoes() {
        return totalMovimentacoes;
    }
    public void setTotalMovimentacoes(Integer totalMovimentacoes) {
        this.totalMovimentacoes = totalMovimentacoes;
    }
    public BigDecimal getValorPago() {
        return valorPago;
    }
    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }
    public BigDecimal getSaldoAtual() {
        return saldoAtual;
    }
    public void setSaldoAtual(BigDecimal saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    
}
