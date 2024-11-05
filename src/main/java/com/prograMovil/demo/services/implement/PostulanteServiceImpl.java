package com.prograMovil.demo.services.implement;

import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.exceptions.NotFoundException;
import com.prograMovil.demo.models.Postulante;
import com.prograMovil.demo.repositories.PostulanteRepository;
import com.prograMovil.demo.services.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostulanteServiceImpl implements PostulanteService {
    @Autowired
    private PostulanteRepository postulanteRepository;

    @Override
    public PostulanteDTO getPostulante(Integer id){
        Optional<Postulante> postulante = postulanteRepository.findById(id);
        if(postulante.isPresent()){
            return null;
        }else{
            throw new NotFoundException("Postulante", id);
        }
    }
    @Override
    public Postulante savePostulante(PostulanteDTO postulanteDTO){
        return null;
    }
    public PostulanteDTO toDTO(Postulante postulante){
        PostulanteDTO dto = new PostulanteDTO();
        dto.setNombre(postulante.getNombre());
        dto.setApellido(postulante.getApellido());
        dto.setCarrera(postulante.getCarrera());
        dto.setDescripcion(postulante.getDescripcion());
        dto.setCelular(postulante.getCelular());
        dto.setCorreo(postulante.getCorreo());
        dto.setRol(postulante.getRol());
        return dto;
    }
    public Postulante toPostulante(PostulanteDTO postulanteDTO){
        Postulante postulante = new Postulante();
        postulante.setNombre(postulanteDTO.getNombre());
        postulante.setApellido(postulanteDTO.getApellido());
        postulante.setCarrera(postulanteDTO.getCarrera());
        postulante.setDescripcion(postulanteDTO.getDescripcion());
        postulante.setCelular(postulanteDTO.getCelular());
        postulante.setCorreo(postulanteDTO.getCorreo());
        postulante.setRol(postulanteDTO.getRol());
        return postulante;
    }
}
