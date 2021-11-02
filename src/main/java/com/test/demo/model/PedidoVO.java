package com.test.demo.model;

import com.test.demo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoVO {

    String idPedido;
    Status status;
    VencimentoPedidoVO vencimento;
}
