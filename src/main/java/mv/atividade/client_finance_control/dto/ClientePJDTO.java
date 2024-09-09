package mv.atividade.client_finance_control.dto;

import java.util.Date;

import mv.atividade.client_finance_control.entities.ClientePJ;

public class ClientePJDTO {

    private Long id;
    private String nome;

    private String cnpj;
    private String razaoSocial;
    private String telefone;

    private Date criadoEm;

      public ClientePJDTO(Long id, String nome, String cnpj, String razaoSocial, String telefone, Date criadoEm) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
        this.criadoEm = criadoEm;
    }

    public ClientePJDTO(ClientePJ entity) {
        id = entity.getId();
        nome = entity.getNome();
        cnpj = entity.getCnpj();
        razaoSocial = entity.getRazaoSocial();
        telefone = entity.getTelefone();
        criadoEm = entity.getCriadoEm();
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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
