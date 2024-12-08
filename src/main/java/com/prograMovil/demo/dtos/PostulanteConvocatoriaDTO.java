package com.prograMovil.demo.dtos;
import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.PostulanteConvocatoria;
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
    private ConvocatoriaDTO convocatoria;

    public PostulanteConvocatoriaDTO(PostulanteConvocatoria postulanteConvocatoria) {
        this.aceptado = postulanteConvocatoria.isAceptado();
        this.curriculum = postulanteConvocatoria.getCurriculum();
        Convocatoria nuevo = postulanteConvocatoria.getConvocatoria();
        /*this.convocatoria = new ConvocatoriaDTO(nuevo.getId(), nuevo.getTitulo(),nuevo.getDescripcion(),
                nuevo.getImagen(),nuevo.getCantidadMaxPost(),nuevo.getFechaInicioReclutamiento(), nuevo.getFechaFinReclutamiento()
                nuevo.getFechaInicioSeleccion() nuevo.getFechaFinSeleccion(),nuevo.getEmpresa().getId());*/
        this.convocatoria = new ConvocatoriaDTO(nuevo);
    }
}
