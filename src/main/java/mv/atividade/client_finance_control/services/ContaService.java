package mv.atividade.client_finance_control.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mv.atividade.client_finance_control.entities.Conta;
import mv.atividade.client_finance_control.repositories.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta addConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta getContaById(Long id) {
        return contaRepository.findById(id).orElse(null);
    }

    public List<Conta> getAllContas() {
        return contaRepository.findAll(Sort.by("id"));
    }

    public Conta updateConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public void deleteConta(Long id) {
        contaRepository.deleteById(id);
    }
}
