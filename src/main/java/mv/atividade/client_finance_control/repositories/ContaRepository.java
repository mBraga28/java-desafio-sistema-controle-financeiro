package mv.atividade.client_finance_control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mv.atividade.client_finance_control.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
