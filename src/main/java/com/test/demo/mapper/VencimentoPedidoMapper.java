package com.test.demo.mapper;

import com.test.demo.dto.PedidoDto;
import com.test.demo.dto.VencimentoPedidoDto;
import com.test.demo.model.PedidoVO;
import com.test.demo.model.VencimentoPedidoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VencimentoPedidoMapper {

    VencimentoPedidoMapper INSTANCE = Mappers.getMapper(VencimentoPedidoMapper.class);

    VencimentoPedidoDto toModel(VencimentoPedidoVO pedidoVO);

    VencimentoPedidoVO toVO(VencimentoPedidoDto vencimento);
}
