package mv.atividade.client_finance_control.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mv.atividade.client_finance_control.entities.Endereco;
import mv.atividade.client_finance_control.repositories.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco addEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco getEnderecoById(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco updateEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
