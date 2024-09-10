package mv.atividade.client_finance_control.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import mv.atividade.client_finance_control.enums.TipoCliente;

@Entity
public class ClientePF extends Cliente {
    private String cpf;

    public ClientePF(Long id, String nome, String telefone, Date criadoEm, List<Conta> contas, Endereco endereco, List<Movimentacao> movimentacoes, String cpf) {
        super(id, nome, telefone, criadoEm, contas, endereco, movimentacoes);
        this.cpf = cpf;
    }

    public ClientePF() {
        this.setTipo(TipoCliente.PF);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        ClientePF other = (ClientePF) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    
}
