package com.test.demo.service;

import com.test.demo.domain.*;
import com.test.demo.dto.VencimentoPedidoDto;
import com.test.demo.enums.Status;
import com.test.demo.mapper.PedidoMapper;
import com.test.demo.dto.PedidoDto;
import com.test.demo.mapper.VencimentoPedidoMapper;
import com.test.demo.model.PedidoVO;
import com.test.demo.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class PedidoService {

    @Autowired
    private final PedidoRepository pedidoRepository;

    private final PedidoMapper pedidoMapper = PedidoMapper.INSTANCE;
    private final VencimentoPedidoMapper vencimentoMapper = VencimentoPedidoMapper.INSTANCE;

    public ServiceResponse<PedidoVO> consultar(String idPedido){
       Optional<PedidoDto> pedido = pedidoRepository.findById(Long.valueOf(idPedido));
       ServiceResponse<PedidoVO> pedidoVOServiceResponse = new ServiceResponse<PedidoVO>();
        if (pedido.isPresent()) {

            pedidoVOServiceResponse.setResponse(pedidoMapper.toVO(pedido.get()));
            pedidoVOServiceResponse.setSuccess(true);

            return  pedidoVOServiceResponse;

        }
        pedidoVOServiceResponse.setSuccess(false);

        return  pedidoVOServiceResponse;
    }

    public  ServicePageableResponse<List<PedidoVO>> listar(){

        ServicePageableResponse<List<PedidoVO>> listaResponse = new ServicePageableResponse<List<PedidoVO>>();

        List<PedidoVO> lista =  pedidoRepository.findAll()
                .stream()
                .map(pedidoMapper::toVO)
                .collect(Collectors.toList());

        listaResponse.setResponse(lista);
        listaResponse.setSuccess(true);

        return listaResponse;
    }

    public ServiceResponse<Void> criar(PedidoVO pedido){
        pedidoRepository.save(pedidoMapper.toModel(pedido));

        ServiceResponse<Void> service = new ServiceResponse<>();
        service.setSuccess(true);
        return service;
    }

    public ServiceResponse<Void> atualizar(String idPedido, Status status){
        PedidoVO pedido = consultar(idPedido).getResponse();
        pedido.setStatus(status);
        return criar(pedido);
    }


    public ServiceResponse<Void> atualizarVencimentoPedido(String idPedido, VencimentoPedidoDto vencimentoPedidoDto){
        PedidoVO pedido = consultar(idPedido).getResponse();
        pedido.setVencimento(vencimentoMapper.toVO(vencimentoPedidoDto));
        return criar(pedido);
    }


}
