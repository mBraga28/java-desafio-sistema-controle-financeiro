package mv.atividade.client_finance_control.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import mv.atividade.client_finance_control.enums.TipoCliente;

@Entity
@Table(name = "tb_pessoa_juridica")
public class ClientePJ extends Cliente {
    private String cnpj;
    private String razaoSocial;

    public ClientePJ(Long id, String nome, String telefone, Date criadoEm, List<Conta> contas, Endereco endereco, List<Movimentacao> movimentacoes, String cnpj,
            String razaoSocial) {
        super(id, nome, telefone, criadoEm, contas, endereco, movimentacoes);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }
    public ClientePJ() {
        this.setTipo(TipoCliente.PJ);
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClientePJ other = (ClientePJ) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }
}