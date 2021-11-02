package com.test.demo.dto;

import com.test.demo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PedidoDto {
    @Id
    String idPedido;
    Status status;

    VencimentoPedidoDto vencimentoPedidoDto;
}
