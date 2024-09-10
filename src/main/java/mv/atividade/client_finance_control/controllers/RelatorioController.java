package mv.atividade.client_finance_control.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mv.atividade.client_finance_control.dto.RelatorioReceitaDTO;
import mv.atividade.client_finance_control.dto.RelatorioSaldoClienteDTO;
import mv.atividade.client_finance_control.dto.RelatorioSaldoClienteSimplesDTO;
import mv.atividade.client_finance_control.services.RelatorioService;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<RelatorioSaldoClienteDTO> gerarRelatorioCliente(@PathVariable Long idCliente) {
        RelatorioSaldoClienteDTO relatorio = relatorioService.gerarRelatorioSaldoCliente(idCliente);
        return ResponseEntity.ok(relatorio);
    }


    @GetMapping("/cliente/{idCliente}/periodo")
    public ResponseEntity<RelatorioSaldoClienteDTO> gerarRelatorioClientePeriodo(@PathVariable Long idCliente,
                                                                                @RequestParam("dataInicial") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicial,
                                                                                @RequestParam("dataFinal") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFinal) {
        RelatorioSaldoClienteDTO relatorio = relatorioService.gerarRelatorioSaldoClientePorPeriodo(idCliente, dataInicial, dataFinal);
        return ResponseEntity.ok(relatorio);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<RelatorioSaldoClienteSimplesDTO>> gerarRelatorioTodosClientes(
            @RequestParam("dataReferencia") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataReferencia) {

        List<RelatorioSaldoClienteSimplesDTO> relatorios = relatorioService.gerarRelatorioTodosClientes(dataReferencia);
        return ResponseEntity.ok(relatorios);
    }

    @GetMapping("/receita")
    public ResponseEntity<RelatorioReceitaDTO> gerarRelatorioReceita(
            @RequestParam("dataInicial") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFinal) {

        RelatorioReceitaDTO relatorio = relatorioService.gerarRelatorioReceita(dataInicial, dataFinal);
        return ResponseEntity.ok(relatorio);
    }
}