package com.prograMovil.demo.services.implement;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.PostulanteConvocatoriaDTO;
import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.exceptions.NotFoundException;
import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Postulante;
import com.prograMovil.demo.models.PostulanteConvocatoria;
import com.prograMovil.demo.repositories.ConvocatoriaRepository;
import com.prograMovil.demo.repositories.PostulanteConvocatoriaRepository;
import com.prograMovil.demo.repositories.PostulanteRepository;
import com.prograMovil.demo.services.PostulanteConvocService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostulanteConvocImpl implements PostulanteConvocService {
    @Autowired
    private PostulanteConvocatoriaRepository postulanteConvocatoriaRepository;
    @Autowired
    private ConvocatoriaServiceImpl convocatoriaServiceImpl;
    @Autowired
    @Lazy
    private PostulanteServiceImpl postulanteServiceImpl;
    @Autowired
    private ConvocatoriaRepository convocatoriaRepository;
    @Autowired
    private PostulanteRepository postulanteRepository;

    @Override
    public void setAceptado(Integer idConvocatoria,Integer idPostulante, boolean aceptado){
        PostulanteConvocatoria postulanteConvocatoria = getPostulantConvocatoria(idPostulante,idConvocatoria);
        if(postulanteConvocatoria != null){
            postulanteConvocatoria.setAceptado(aceptado);
            postulanteConvocatoriaRepository.save(postulanteConvocatoria);
        }else{
            throw new NotFoundException("No se encontro la entidad", 404);
        }

    }
    public PostulanteConvocatoria getPostulantConvocatoria(Integer idPostulante,Integer idConvocatoria){
        Optional<Postulante> postulante = postulanteRepository.findById(idPostulante);
        Optional<Convocatoria> convocatoria = convocatoriaRepository.findById(idConvocatoria);
        Optional<PostulanteConvocatoria> postulanteConvocatoria = postulanteConvocatoriaRepository.findByConvocatoriaAndPostulante(convocatoria.get(),postulante.get());
        if(postulanteConvocatoria.isPresent()){
            return postulanteConvocatoria.get();
        }else{
            throw new NotFoundException("No se encontro la entidad", 404);
        }
    }
    public PostulanteConvocatoriaDTO toDTO(PostulanteConvocatoria postulante) {
        PostulanteConvocatoriaDTO dto = new PostulanteConvocatoriaDTO();
        dto.setAceptado(postulante.isAceptado());
        dto.setCurriculum(postulante.getCurriculum());
        return dto;
    }
    public PostulanteConvocatoria toEntity(PostulanteConvocatoriaDTO dto) {
        PostulanteConvocatoria postulante = new PostulanteConvocatoria();
        postulante.setAceptado(dto.isAceptado());
        postulante.setCurriculum(dto.getCurriculum());
        return postulante;
    }
}
