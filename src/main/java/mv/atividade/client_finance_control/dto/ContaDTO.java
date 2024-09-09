package mv.atividade.client_finance_control.dto;

import java.math.BigDecimal;

import mv.atividade.client_finance_control.entities.Conta;

public class ContaDTO {

    private Long id;
    private String numero;
    private String banco;
    private String agencia;
    private BigDecimal saldo;

    private Long clienteId;

    public ContaDTO(Long id, String numero, String banco, String agencia, BigDecimal saldo, Long clienteId) {
        this.id = id;
        this.numero = numero;
        this.banco = banco;
        this.agencia = agencia;
        this.saldo = saldo;
        this.clienteId = clienteId;
    }

    public ContaDTO(Conta entity) {
        id = entity.getId();
        numero = entity.getNumero();
        banco = entity.getBanco();
        agencia = entity.getAgencia();
        saldo = entity.getSaldo();
        clienteId = entity.getCliente().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    

}
