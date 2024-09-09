package mv.atividade.client_finance_control.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RelatorioSaldoClienteDTO {

    private Long idCliente;
    private String nomeCliente;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;
    private BigDecimal saldoInicial;
    private BigDecimal saldoFinal;

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
    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }
    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    
}
