package com.test.demo.mapper;

import com.test.demo.model.PedidoVO;
import com.test.demo.dto.PedidoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    PedidoDto toModel(PedidoVO pedidoVO);

    PedidoVO toVO(PedidoDto pedido);
}
