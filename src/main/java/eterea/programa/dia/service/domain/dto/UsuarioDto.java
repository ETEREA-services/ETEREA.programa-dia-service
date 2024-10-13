package eterea.programa.dia.service.domain.dto;

import lombok.Data;

@Data
public class UsuarioDto {

    private String login;
    private String descripcion;
    private String password;
    private String email;
    private Integer nivel = 0;
    private String pin;
    private String cierreRecipientType;
    private String consolidadoRecipientType;
    private Long usuarioId;

}
