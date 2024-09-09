package mv.atividade.client_finance_control.services;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import mv.atividade.client_finance_control.dto.MovimentacaoDTO;
import mv.atividade.client_finance_control.dto.RelatorioSaldoClienteDTO;
import mv.atividade.client_finance_control.entities.Cliente;
import mv.atividade.client_finance_control.entities.Movimentacao;
import mv.atividade.client_finance_control.repositories.ClienteRepository;
import mv.atividade.client_finance_control.repositories.MovimentacaoRepository;
import mv.atividade.client_finance_control.repositories.SaldoClienteRepository;

@Service
public class RelatorioService {

    @Autowired
    private SaldoClienteRepository saldoClienteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public RelatorioSaldoClienteDTO gerarRelatorioSaldoCliente(Long idCliente, Date dataInicial, Date dataFinal) {
        // Obter informações do cliente
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));

        // Obter o saldo final do cliente no período
        BigDecimal saldoFinal = saldoClienteRepository.calcularSaldoClientePeriodo(idCliente, dataInicial, dataFinal);

        // Obter as movimentações do cliente no período
        List<Movimentacao> movimentacoes = movimentacaoRepository.findByClienteIdAndDataBetween(idCliente, dataInicial, dataFinal);
        List<MovimentacaoDTO> movimentacoesDTO = movimentacoes.stream()
                .map(movimentacao -> new MovimentacaoDTO(movimentacao.getId(), movimentacao.getTipo(), movimentacao.getValor(), movimentacao.getData()))
                .collect(Collectors.toList());

        // Criar o DTO do relatório
        RelatorioSaldoClienteDTO relatorio = new RelatorioSaldoClienteDTO();
        relatorio.setIdCliente(cliente.getId());
        relatorio.setNomeCliente(cliente.getNome());
        relatorio.setDataCadastro(cliente.getCriadoEm());
        relatorio.setSaldoInicial(calcularSaldoInicial(cliente, dataInicial)); // Lógica para calcular o saldo inicial
        relatorio.setSaldoFinal(saldoFinal);

        return relatorio;
    }

    private BigDecimal calcularSaldoInicial(Cliente cliente, Date dataInicial) {
        List<Movimentacao> movimentacoesAnteriores = movimentacaoRepository.findByClienteIdAndDataBefore(cliente.getId(), dataInicial);
        return movimentacoesAnteriores.stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
