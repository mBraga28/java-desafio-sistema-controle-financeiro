package mv.atividade.client_finance_control.dto;

import java.util.Date;

import mv.atividade.client_finance_control.entities.ClientePF;

public class ClientePFDTO {

    private Long id;
    private String nome;

    private String cpf;
    private String telefone;

    private Date criadoEm;

    

    public ClientePFDTO(Long id, String nome, String cpf, String telefone, Date criadoEm) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.criadoEm = criadoEm;
    }

    public ClientePFDTO(ClientePF entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cpf = entity.getCpf();
        this.telefone = entity.getTelefone();
        this.criadoEm = entity.getCriadoEm();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    
}
