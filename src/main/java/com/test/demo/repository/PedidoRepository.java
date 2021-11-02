package com.test.demo.repository;


import com.test.demo.dto.PedidoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoDto, Long> {
}
