package mv.atividade.client_finance_control.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mv.atividade.client_finance_control.entities.Conta;
import mv.atividade.client_finance_control.entities.Movimentacao;
import mv.atividade.client_finance_control.enums.TipoMovimentacao;
import mv.atividade.client_finance_control.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ContaService contaService;

    public Movimentacao saveMovimentacao(Movimentacao movimentacao) {
         // Validações: conta existe, valor válido, tipo de movimentação válido, etc.
        Conta conta = contaService.getContaById(movimentacao.getConta().getId());
        // Atualizar saldo da conta
        if (movimentacao.getTipo() == TipoMovimentacao.DEBITO) {
            conta.setSaldo(conta.getSaldo().subtract(movimentacao.getValor()));
        } else {
            conta.setSaldo(conta.getSaldo().add(movimentacao.getValor()));
        }
        contaService.saveConta(conta);
        return movimentacaoRepository.save(movimentacao);
    }
}
