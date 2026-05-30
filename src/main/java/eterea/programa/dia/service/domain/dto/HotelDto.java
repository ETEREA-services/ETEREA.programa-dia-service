package eterea.programa.dia.service.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {

    private Integer hotelId;
    private String nombre = "";
    private Byte extras = 0;
    private Byte paradaTraslado = 0;
    private Byte puntoEncuentro = 0;

}
