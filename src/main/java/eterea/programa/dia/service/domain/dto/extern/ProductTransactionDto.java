package eterea.programa.dia.service.domain.dto.extern;

import lombok.Data;

@Data
public class ProductTransactionDto {

    private Long productTransactionId;
    private Long orderNumberId;
    private String nombreProducto = "";
    private String montoProducto;

}
