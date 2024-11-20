package com.prograMovil.demo.services.implement;

import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.exceptions.NotFoundException;
import com.prograMovil.demo.models.Empresa;
import com.prograMovil.demo.models.Postulante;
import com.prograMovil.demo.models.PostulanteConvocatoria;
import com.prograMovil.demo.repositories.PostulanteRepository;
import com.prograMovil.demo.services.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostulanteServiceImpl implements PostulanteService {
    @Autowired
    private PostulanteRepository postulanteRepository;
    @Autowired
    private PostulanteConvocImpl postulanteConvocImpl;

    @Override
    public PostulanteDTO getPostulante(Integer id){
        Optional<Postulante> postulante = postulanteRepository.findById(id);
        if(postulante.isPresent()){
            return toDTO(postulante.get(),null);
        }else{
            throw new NotFoundException("Postulante", id);
        }
    }
    @Override
    public Integer loginPostulante(PostulanteDTO postulante){
        Postulante postulante1 = toPostulante(postulante);
        Optional<Postulante> postulante2 = postulanteRepository.findByUsuarioAndContrasenia(postulante.getUsuario(), postulante.getContrasenia());
        if(postulante2.isPresent()){
            return postulante2.get().getId();
        }else{
            throw new NotFoundException("Postulante", 404);
        }
    }
    @Override
    public ResponseEntity<String> setPostulante(Integer idPostulante, PostulanteDTO postulantedto){
        Optional<Postulante> postulante = postulanteRepository.findById(idPostulante);
        if(postulante.isPresent()){
            Postulante getPostulante = postulante.get();
            if (postulantedto.getNombre() != null) {
                getPostulante.setNombre(postulantedto.getNombre());
            }
            if (postulantedto.getApellido() != null) {
                getPostulante.setApellido(postulantedto.getApellido());
            }
            if (postulantedto.getCarrera() != null) {
                getPostulante.setCarrera(postulantedto.getCarrera());
            }
            if(postulantedto.getDescripcion() != null) {
                getPostulante.setDescripcion(postulantedto.getDescripcion());
            }
            if(postulantedto.getCelular() != null) {
                getPostulante.setCelular(postulantedto.getCelular());
            }
            if(postulantedto.getCorreo() != null) {
                getPostulante.setCorreo(postulantedto.getCorreo());
            }
            postulanteRepository.save(getPostulante);
            return ResponseEntity.ok("");
        }else{
            throw new NotFoundException("Postulante", postulantedto.getId());
        }
    }

    @Override
    public PostulanteDTO savePostulante(PostulanteDTO postulanteDTO){
        Postulante postulante = toPostulante(postulanteDTO);
        return toDTO(postulanteRepository.save(postulante),null);
    }
    public PostulanteDTO toDTO(Postulante postulante, PostulanteConvocatoria postulanteConvocatoria){
        PostulanteDTO dto = new PostulanteDTO();
        dto.setId(postulante.getId());
        dto.setNombre(postulante.getNombre());
        dto.setApellido(postulante.getApellido());
        dto.setCarrera(postulante.getCarrera());
        dto.setDescripcion(postulante.getDescripcion());
        dto.setCelular(postulante.getCelular());
        dto.setCorreo(postulante.getCorreo());
        dto.setRol(postulante.getRol());
        if(postulanteConvocatoria != null){
            dto.setDatosAdicionales(postulanteConvocImpl.toDTO(postulanteConvocatoria));
            //dto.setDatosAdicionales()
        }
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
        postulante.setUsuario(postulanteDTO.getUsuario());
        postulante.setContrasenia(postulanteDTO.getContrasenia());
        postulante.setRol(postulanteDTO.getRol());
        return postulante;
    }
}
