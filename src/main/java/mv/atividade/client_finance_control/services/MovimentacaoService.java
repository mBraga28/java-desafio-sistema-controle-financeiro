package mv.atividade.client_finance_control.services;

import java.math.BigDecimal;
import java.util.List;

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

    public void transferir(Long contaOrigemId, Long contaDestinoId, BigDecimal valor) {
        // Validações: verificar se as contas existem, se há saldo suficiente, etc.

        // Bloqueia as contas para evitar inconsistências
        Conta contaOrigem = contaService.getContaById(contaOrigemId);
        Conta contaDestino = contaService.getContaById(contaDestinoId);

        // Cria as movimentações
        Movimentacao movimentacaoOrigem = new Movimentacao(contaOrigem, contaOrigem.getSaldo().subtract(valor));
        Movimentacao movimentacaoDestino = new Movimentacao(contaDestino, contaDestino.getSaldo().add(valor));

        // Persiste as movimentações
        movimentacaoRepository.saveAll(List.of(movimentacaoOrigem, movimentacaoDestino));
    }
}
