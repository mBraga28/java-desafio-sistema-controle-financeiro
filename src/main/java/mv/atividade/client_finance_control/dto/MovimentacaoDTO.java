package mv.atividade.client_finance_control.dto;

import java.math.BigDecimal;
import java.util.Date;

import mv.atividade.client_finance_control.entities.Movimentacao;
import mv.atividade.client_finance_control.enums.TipoMovimentacao;

public class MovimentacaoDTO {

    private Long id;

    private long contaId;

    private TipoMovimentacao tipo;

    private BigDecimal valor;

    private Date data;

    public MovimentacaoDTO(Long id, Long contaId, TipoMovimentacao tipo, BigDecimal valor, Date data) {
        this.id = id;
        this.contaId = contaId;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public MovimentacaoDTO(Long id, TipoMovimentacao tipo, BigDecimal valor, Date data) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public MovimentacaoDTO(Movimentacao entity) {
        id = entity.getId();
        contaId = entity.getConta().getId();
        tipo = entity.getTipo();
        valor = entity.getValor();
        data = entity.getData();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
}
