package mv.atividade.client_finance_control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mv.atividade.client_finance_control.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
