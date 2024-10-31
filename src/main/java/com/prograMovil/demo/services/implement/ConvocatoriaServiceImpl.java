package com.prograMovil.demo.services.implement;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.EmpresaDTO;
import com.prograMovil.demo.exceptions.NotFoundException;
import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Empresa;
import com.prograMovil.demo.repositories.ConvocatoriaRepository;
import com.prograMovil.demo.repositories.EmpresaRepository;
import com.prograMovil.demo.services.ConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConvocatoriaServiceImpl implements ConvocatoriaService {
    @Autowired
    private EmpresaServiceImpl empresaService;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private ConvocatoriaRepository convocatoriaRepository;
    @Override
    public ConvocatoriaDTO getConvocatoriaById(Integer idConvocatoria){
        return null;
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
}
