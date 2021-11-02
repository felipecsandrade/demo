package com.test.demo.controller;

import com.test.demo.domain.*;
import com.test.demo.dto.PedidoListarDto;
import com.test.demo.dto.VencimentoPedidoDto;
import com.test.demo.enums.Status;
import com.test.demo.model.PedidoVO;
import com.test.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoResource{

        @Autowired
        private final PedidoService pedidoService;

        @GetMapping("/{idPedido}")
        public ResponseEntity<ServiceResponse<PedidoVO>> consultar(@PathVariable String idPedido) {
            return ResponseEntity.ok().body(pedidoService.consultar(idPedido));
        }

        @GetMapping
        public ResponseEntity<ServicePageableResponse<List<PedidoVO>>> listar(PedidoListarDto pedidoListarDto){
            return ResponseEntity.ok().body(pedidoService.listar());

        }
    PedidoListarDto
        @PostMapping
        public ResponseEntity<ServiceResponse<Void>> criar(@RequestBody PedidoVO pedido){
                return ResponseEntity.ok().body(pedidoService.criar(pedido));
        }

        @PostMapping("{idPedido}")
        public ResponseEntity<ServiceResponse<Void>> alterar(@PathVariable String idPedido, @RequestBody PedidoVO pedido) {
            pedido.setIdPedido(idPedido);
            return ResponseEntity.ok().body(pedidoService.criar(pedido));
        }

        @DeleteMapping("{idPedido}")
        public ResponseEntity<ServiceResponse<Void>> excluir(@PathVariable String idPedido, @RequestBody PedidoVO pedido){
            return ResponseEntity.noContent().build();
        }

        @PutMapping("{idPedido}/status/{status}")
        public ResponseEntity<ServiceResponse<Void>> atualizarStatus(@PathVariable String idPedido, @PathVariable Status status){
            return ResponseEntity.ok().body(pedidoService.atualizar(idPedido, status));
        }

        @PostMapping("{idPedido}/vecimento/")
        public ResponseEntity<ServiceResponse<Void>> atualizarVencimentoPedido(@PathVariable String idPedido, @RequestBody VencimentoPedidoDto vencimentoPedidoDto){
            return ResponseEntity.ok().body(pedidoService.atualizarVencimentoPedido(idPedido, vencimentoPedidoDto));
        }

}