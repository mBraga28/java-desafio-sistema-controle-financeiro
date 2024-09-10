package mv.atividade.client_finance_control.services;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import mv.atividade.client_finance_control.dto.EnderecoDTO;
import mv.atividade.client_finance_control.dto.RelatorioClienteDTO;
import mv.atividade.client_finance_control.dto.RelatorioReceitaDTO;
import mv.atividade.client_finance_control.dto.RelatorioSaldoClienteDTO;
import mv.atividade.client_finance_control.dto.RelatorioSaldoClienteSimplesDTO;
import mv.atividade.client_finance_control.entities.Cliente;
import mv.atividade.client_finance_control.entities.Movimentacao;
import mv.atividade.client_finance_control.enums.TipoMovimentacao;
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

    public RelatorioSaldoClienteDTO gerarRelatorioSaldoCliente(Long idCliente) {
        // Obter informações do cliente
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    
        // Obter todas as movimentações do cliente
        Optional<Movimentacao> todasMovimentacoes = movimentacaoRepository.findById(idCliente);
    
        // Agrupar as movimentações por tipo (crédito e débito)
        Map<TipoMovimentacao, List<Movimentacao>> movimentacoesPorTipo = todasMovimentacoes.stream()
                .collect(Collectors.groupingBy(Movimentacao::getTipo));
    
        // Calcular os valores
        List<Movimentacao> movimentacoesCredito = movimentacoesPorTipo.getOrDefault("Crédito", Collections.emptyList());
        List<Movimentacao> movimentacoesDebito = movimentacoesPorTipo.getOrDefault("Débito", Collections.emptyList());
    
        BigDecimal valorTotalCredito = movimentacoesCredito.stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal valorTotalDebito = movimentacoesDebito.stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    
        todasMovimentacoes = movimentacaoRepository.findById(cliente.getId());
        BigDecimal saldoInicial = todasMovimentacoes.stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
                
        // Calcular o saldo final
        BigDecimal saldoFinal = valorTotalCredito.subtract(valorTotalDebito);
    
        // Criar o DTO do relatório
        RelatorioSaldoClienteDTO relatorio = new RelatorioSaldoClienteDTO();
        relatorio.setIdCliente(cliente.getId());
        relatorio.setNomeCliente(cliente.getNome());
        relatorio.setDataCadastro(cliente.getCriadoEm());
        relatorio.setEndereco(new EnderecoDTO(cliente.getEndereco())); // Supondo que Cliente tenha um atributo endereco
        relatorio.setMovimentacoesCredito(movimentacoesCredito.size());
        relatorio.setMovimentacoesDebito(movimentacoesDebito.size());
        relatorio.setTotalMovimentacoes(movimentacoesCredito.size() + movimentacoesDebito.size());
        relatorio.setValorPago(valorTotalCredito); // Considerando que valor pago seja o total de créditos
        relatorio.setSaldoInicial(saldoInicial);
        relatorio.setSaldoAtual(saldoFinal);
    
        return relatorio;
    }

    public RelatorioSaldoClienteDTO gerarRelatorioSaldoClientePorPeriodo(Long idCliente, java.util.Date dataInicial, java.util.Date dataFinal) {
        // Obter informações do cliente
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        // Obter o saldo final do cliente no período
        BigDecimal saldoFinal = saldoClienteRepository.calcularSaldoClientePeriodo(idCliente, dataInicial, dataFinal);

        // Obter as movimentações do cliente no período
        List<Movimentacao> movimentacoesPeriodo = movimentacaoRepository.findByClienteIdAndDataBetween(idCliente, dataInicial, dataFinal);
        // Agrupar as movimentações por tipo (crédito e débito)
        Map<TipoMovimentacao, List<Movimentacao>> movimentacoesPorTipo = movimentacoesPeriodo.stream()
                .collect(Collectors.groupingBy(Movimentacao::getTipo));

        // Calcular os valores
        List<Movimentacao> movimentacoesCredito = movimentacoesPorTipo.getOrDefault("Crédito", Collections.emptyList());
        List<Movimentacao> movimentacoesDebito = movimentacoesPorTipo.getOrDefault("Débito", Collections.emptyList());
    
        BigDecimal valorTotalCredito = movimentacoesCredito.stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal valorTotalDebito = movimentacoesDebito.stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);          

        // Calcular o saldo final
        saldoFinal = valorTotalCredito.subtract(valorTotalDebito);        

        // Criar o DTO do relatório
        RelatorioSaldoClienteDTO relatorio = new RelatorioSaldoClienteDTO();
        relatorio.setIdCliente(cliente.getId());
        relatorio.setNomeCliente(cliente.getNome());
        relatorio.setDataCadastro(cliente.getCriadoEm());
        relatorio.setMovimentacoesCredito(movimentacoesCredito.size());
        relatorio.setMovimentacoesDebito(movimentacoesDebito.size());
        relatorio.setTotalMovimentacoes(movimentacoesCredito.size() + movimentacoesDebito.size());
        relatorio.setSaldoInicial(calcularSaldoInicial(cliente, dataInicial)); // Lógica para calcular o saldo inicial
        relatorio.setSaldoAtual(saldoFinal);

        return relatorio;
    }

    private BigDecimal calcularSaldoInicial(Cliente cliente, Date dataInicial) {
        List<Movimentacao> movimentacoesAnteriores = movimentacaoRepository.findByClienteIdAndDataBefore(cliente.getId(), dataInicial);
        return movimentacoesAnteriores.stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<RelatorioSaldoClienteSimplesDTO> gerarRelatorioTodosClientes(Date dataReferencia) {
        List<Cliente> todosClientes = clienteRepository.findAll();

        return todosClientes.stream()
                .map(cliente -> {
                    RelatorioSaldoClienteSimplesDTO relatorio = new RelatorioSaldoClienteSimplesDTO();
                    relatorio.setIdCliente(cliente.getId());
                    relatorio.setNomeCliente(cliente.getNome());
                    relatorio.setDataCadastro(cliente.getCriadoEm());

                    BigDecimal saldo = calcularSaldoNaData(cliente, dataReferencia);
                    relatorio.setSaldo(saldo);

                    return relatorio;
                })
                .collect(Collectors.toList());
    }

    private BigDecimal calcularSaldoNaData(Cliente cliente, Date dataReferencia) {
        // Lógica para calcular o saldo do cliente na data de referência
        // Considerar as movimentações anteriores à dataReferencia e aplicar a lógica de cálculo

        List<Movimentacao> movimentacoesAnteriores = movimentacaoRepository.findByClienteIdAndDataBefore(cliente.getId(), dataReferencia);
        BigDecimal saldoInicial = movimentacoesAnteriores.stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalMovimentacoes = movimentacoesAnteriores.stream()
                .map(Movimentacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return saldoInicial.add(totalMovimentacoes);
    }

    public RelatorioReceitaDTO gerarRelatorioReceita(Date dataInicial, Date dataFinal) {
        Optional<Movimentacao> movimentacoes = movimentacaoRepository.findByDataBetween(dataInicial, dataFinal);

        Map<Long, List<Movimentacao>> movimentacoesPorCliente = movimentacoes.stream()
                .collect(Collectors.groupingBy(Movimentacao::getId));

        RelatorioReceitaDTO relatorio = new RelatorioReceitaDTO();
        relatorio.setPeriodo(String.format("%s a %s", dataInicial, dataFinal));

        relatorio.getClientes().addAll(
            movimentacoesPorCliente.entrySet().stream()
                    .map(entry -> {
                        RelatorioClienteDTO relatorioCliente = new RelatorioClienteDTO();
                        relatorioCliente.setClienteId(entry.getKey());
                        relatorioCliente.setQuantidadeMovimentacoes(entry.getValue().size());
                        relatorioCliente.setValorTotal(entry.getValue().stream()
                                .map(Movimentacao::getValor)
                                .reduce(BigDecimal::add)
                                .orElse(BigDecimal.ZERO));
                        return relatorioCliente;
                    })
                    .collect(Collectors.toList())
        );

        BigDecimal receitaTotal = movimentacoesPorCliente.values().stream()
            .flatMap(List::stream)
            .map(Movimentacao::getValor)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);

        relatorio.setReceitaTotal(receitaTotal);
        return relatorio;
    }
}
