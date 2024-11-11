package com.prograMovil.demo.services.implement;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.EmpresaDTO;
import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.exceptions.NotFoundException;
import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Empresa;
import com.prograMovil.demo.models.Postulante;
import com.prograMovil.demo.models.PostulanteConvocatoria;
import com.prograMovil.demo.repositories.ConvocatoriaRepository;
import com.prograMovil.demo.repositories.EmpresaRepository;
import com.prograMovil.demo.services.ConvocatoriaService;
import com.prograMovil.demo.services.implement.PostulanteServiceImpl;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConvocatoriaServiceImpl implements ConvocatoriaService {
    @Autowired
    @Lazy
    private EmpresaServiceImpl empresaService;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private ConvocatoriaRepository convocatoriaRepository;
    @Autowired
    @Lazy
    private PostulanteServiceImpl postulanteService;

    @Override
    public ConvocatoriaDTO getConvocatoriaById(Integer idConvocatoria){
        Convocatoria convocatoria = convocatoriaRepository.findById(idConvocatoria).get();
        if (convocatoria == null) {
            throw new NotFoundException("Convocatoria", idConvocatoria);
        }
        return toDTO(convocatoria);
    }
    @Override
    public ConvocatoriaDTO saveConvocatoria(ConvocatoriaDTO convocatoria){
       Optional<Empresa> empresa = empresaRepository.findById(convocatoria.getEmpresa());
        if(empresa.isEmpty()){
            throw new NotFoundException("Empresa",convocatoria.getEmpresa());
        }
        Convocatoria convocatoria1 = toConvocatoria(convocatoria,empresa.get());
        convocatoriaRepository.save(convocatoria1);
        return  new ConvocatoriaDTO(convocatoria1);
    }
    @Override
    public ConvocatoriaDTO updateConvocatoria(ConvocatoriaDTO convocatoria){
        return null;
    }
    @Override
    public List<PostulanteDTO> getPostulantes(Integer idConvocatoria){
        Optional<Convocatoria> convocatoria = convocatoriaRepository.findById(idConvocatoria);
        if(convocatoria.isPresent()) {
            List<Postulante> postulantes = convocatoria.get().getPostulantes()
                    .stream()
                    .map(PostulanteConvocatoria::getPostulante)
                    .collect(Collectors.toList());
            return postulantes.
                    stream()
                    .map(postulante -> postulanteService.toDTO(postulante))
                    .collect(Collectors.toList());
        }else{
            throw new NotFoundException("Convocatoria", idConvocatoria);
        }
    }
    @Override
    public PostulanteDTO getPostulante(Integer idConvocatoria, Integer idPostulante){
        Optional<Convocatoria> convocatoria = convocatoriaRepository.findById(idConvocatoria);
        if(convocatoria.isPresent()){
            Optional<Postulante> postulante = convocatoria.get().getPostulantes()
                    .stream()
                    .map(PostulanteConvocatoria::getPostulante)
                    .filter(p -> p.getId().equals(idPostulante))
                    .findFirst();

             if(postulante.isPresent()){
                 return postulanteService.toDTO(postulante.get());
             }else{
                 throw new NotFoundException("Postulante", idPostulante);
             }
        }else{
            throw new NotFoundException("Convocatoria", idConvocatoria);
        }
    }

    public Convocatoria toConvocatoria(ConvocatoriaDTO dto, Empresa empresa){
        Convocatoria convoc = new Convocatoria();
        convoc.setTitulo(dto.getTitulo());
        convoc.setDescripcion(dto.getDescripcion());
        convoc.setImagen(dto.getImagen());
        convoc.setCantidadMaxPost(dto.getCantidadMaxPost());
        convoc.setFechaInicio(dto.getFechaInicio());
        convoc.setFechaFin(dto.getFechaFin());
        convoc.setEmpresa(empresa);
        return convoc;
    }
    public ConvocatoriaDTO toDTO(Convocatoria convocatoria){
        ConvocatoriaDTO dto = new ConvocatoriaDTO();
        dto.setId(convocatoria.getId());
        dto.setTitulo(convocatoria.getTitulo());
        dto.setDescripcion(convocatoria.getDescripcion());
        dto.setImagen(convocatoria.getImagen());
        dto.setCantidadMaxPost(convocatoria.getCantidadMaxPost());
        dto.setFechaInicio(convocatoria.getFechaInicio());
        dto.setFechaFin(convocatoria.getFechaFin());
        dto.setEmpresa(convocatoria.getEmpresa().getId());
        return dto;
    }
}
