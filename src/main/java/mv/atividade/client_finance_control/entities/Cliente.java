package mv.atividade.client_finance_control.entities;

import jakarta.persistence.*;
import mv.atividade.client_finance_control.enums.TipoCliente;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;

    @Column(columnDefinition = "DATE")
    private Date criadoEm;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Conta> contas;

    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Movimentacao> movimentacoes;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String telefone, Date criadoEm, List<Conta> contas, Endereco endereco, List<Movimentacao> movimentacoes) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.criadoEm = criadoEm;
        this.contas = contas;
        this.endereco = endereco;
        this.movimentacoes = movimentacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }
    
}

