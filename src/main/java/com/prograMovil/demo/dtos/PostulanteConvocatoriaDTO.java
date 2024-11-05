package com.prograMovil.demo.dtos;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostulanteConvocatoriaDTO {
    private boolean aceptado;
    private String curriculum;

}
