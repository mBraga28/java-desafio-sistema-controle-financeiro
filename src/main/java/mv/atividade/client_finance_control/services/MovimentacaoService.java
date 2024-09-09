package mv.atividade.client_finance_control.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mv.atividade.client_finance_control.entities.Conta;
import mv.atividade.client_finance_control.entities.Movimentacao;
import mv.atividade.client_finance_control.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ContaService contaService;

    public Movimentacao saveMovimentacao(Movimentacao movimentacao) {
        // Validações
        Conta conta = contaService.getContaById(movimentacao.getConta().getId());
        movimentacao.setConta(conta);
        return movimentacaoRepository.save(movimentacao);
    }
}
