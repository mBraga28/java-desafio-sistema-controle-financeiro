package mv.atividade.client_finance_control.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mv.atividade.client_finance_control.entities.Movimentacao;
import mv.atividade.client_finance_control.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoService movimentacaoService;  

    @PostMapping
    public ResponseEntity<Movimentacao> salvar(@RequestBody Movimentacao movimentacao) {
        Movimentacao movimentacaoSalva = movimentacaoService.saveMovimentacao(movimentacao);
        return ResponseEntity.created(null).body(movimentacaoSalva);
    }

    // Outros métodos: buscar por id, listar movimentações de uma conta, etc.
}
