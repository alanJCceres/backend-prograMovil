package com.prograMovil.demo.services.implement;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.ConvocatoriaParaPostulantesDTO;
import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.exceptions.NotFoundException;
import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Empresa;
import com.prograMovil.demo.models.Postulante;
import com.prograMovil.demo.models.PostulanteConvocatoria;
import com.prograMovil.demo.repositories.ConvocatoriaRepository;
import com.prograMovil.demo.repositories.EmpresaRepository;
import com.prograMovil.demo.services.ConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    @Lazy
    private PostulanteConvocImpl postulanteConvocImpl;

    @Override
    public ConvocatoriaDTO getConvocatoriaById(Integer idConvocatoria){
        Optional<Convocatoria> convocatoria = convocatoriaRepository.findById(idConvocatoria);
        if (convocatoria.isEmpty()) {
            throw new NotFoundException("Convocatoria", idConvocatoria);
        }
        return new ConvocatoriaDTO(convocatoria.get());
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
            List<PostulanteConvocatoria> postulantes = convocatoria.get().getPostulantes();
            List<PostulanteDTO> postulanteDTOS = postulantes
                    .stream()
                    .map( p -> postulanteService.toDTO(p.getPostulante(),p))
                    .collect(Collectors.toList());
            return postulanteDTOS;
        }else{
            throw new NotFoundException("Convocatoria", idConvocatoria);
        }
    }
    @Override
    public List<PostulanteDTO> getPostulantesEstado(Integer idConvocatoria,String estadoPostulante){
        Optional<Convocatoria> convocatoria = convocatoriaRepository.findById(idConvocatoria);
        if(convocatoria.isPresent()) {
            List<PostulanteConvocatoria> postulantes = convocatoria.get().getPostulantes();
            List<PostulanteDTO> postulanteDTOS = postulantes
                    .stream()
                    .filter(p -> p.getEstado().equals(estadoPostulante))
                    .map( p -> postulanteService.toDTO(p.getPostulante(),p))
                    .collect(Collectors.toList());
            return postulanteDTOS;
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
                 Optional<PostulanteConvocatoria> datosAdicionales = convocatoria.get().getPostulantes()
                         .stream()
                         .filter(p -> p.getPostulante().equals(postulante.get()))
                         .findFirst();
                 if(datosAdicionales.isPresent()) {
                     return postulanteService.toDTO(postulante.get(),datosAdicionales.get());
                 }else{
                     throw new NotFoundException("Postulante Sin datos adicionales", idPostulante);
                 }
             }else{
                 throw new NotFoundException("Postulante", idPostulante);
             }
        }else{
            throw new NotFoundException("Convocatoria", idConvocatoria);
        }
    }
    @Override
    public List<ConvocatoriaDTO> getAllConvocatorias(){
        Date fechaActual = new Date();
        List<Convocatoria> convocatorias=convocatoriaRepository.findAll();
        return convocatorias.stream()
                .filter(c -> fechaActual.compareTo(c.getFechaInicioReclutamiento()) >= 0 && fechaActual.compareTo(c.getFechaFinReclutamiento()) <= 0)
                .map(ConvocatoriaDTO::new)
                .collect(Collectors.toList());

    }

    @Override
    public List<ConvocatoriaParaPostulantesDTO> getAllConvocatoriasParaPostulantes(){
        Date fechaActual = new Date();
        List<Convocatoria> convocatorias=convocatoriaRepository.findAll();
        return convocatorias.stream()
                .filter(c -> (c.getEstado().equals("En curso")))
                .map(ConvocatoriaParaPostulantesDTO::new)
                .collect(Collectors.toList());

    }

    @Override
    public ConvocatoriaParaPostulantesDTO getConvocatoriaWithEmpresaById(Integer idConvocatoria){
        Optional<Convocatoria> convocatoria = convocatoriaRepository.findById(idConvocatoria);
        if (convocatoria.isEmpty()) {
            throw new NotFoundException("Convocatoria", idConvocatoria);
        }
        return new ConvocatoriaParaPostulantesDTO(convocatoria.get());
    }

    public Convocatoria toConvocatoria(ConvocatoriaDTO dto, Empresa empresa){
        Convocatoria convoc = new Convocatoria(dto);
        convoc.setEmpresa(empresa);
        return convoc;
    }
}
