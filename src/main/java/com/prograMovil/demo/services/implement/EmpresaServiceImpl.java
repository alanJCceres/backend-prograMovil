package com.prograMovil.demo.services.implement;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.ConvocatoriaForTableDTO;
import com.prograMovil.demo.dtos.EmpresaDTO;
import com.prograMovil.demo.exceptions.NotFoundException;
import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Empresa;
import com.prograMovil.demo.repositories.ConvocatoriaRepository;
import com.prograMovil.demo.repositories.EmpresaRepository;
import com.prograMovil.demo.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private ConvocatoriaRepository convocatoriaRepository;
    @Autowired
    private ConvocatoriaServiceImpl convocatoriaServiceImpl;

    @Override
    public EmpresaDTO getEmpresaById(Integer idEmpresa) {
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        if (empresa.isPresent()) {
            return toDTO(empresa.get());
        } else {
            throw new NotFoundException("Empresa", idEmpresa);
        }
    }
    @Override
    public Integer loginEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = toEmpresa(empresaDTO);
        Optional<Empresa> getEmpresa= empresaRepository.findByUsuarioAndContrasenia(empresa.getUsuario(), empresa.getContrasenia());
        if(getEmpresa.isPresent()) {
            return getEmpresa.get().getId();
        }else{
            throw new NotFoundException("La empresa no existe",404);
        }
    }
    @Override
    public EmpresaDTO saveEmpresa(EmpresaDTO empresa){
        Empresa empresa1 = toEmpresa(empresa);
        return toDTO(empresaRepository.save(empresa1));
    }
    @Override
    public EmpresaDTO updateEmpresa(EmpresaDTO empresa){
        return null;
    }

    /*@Override
    public List<ConvocatoriaDTO> getConvocatorias(Integer idEmpresa){
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        if (empresa.isPresent()) {
            List<Convocatoria> convocatorias = convocatoriaRepository.findAllByEmpresaId(empresa.get());
            return convocatorias
                    .stream()
                    .map(convocatoria -> convocatoriaServiceImpl.toDTO(convocatoria))
                    .collect(Collectors.toList());
        }else{
            throw new NotFoundException("Empresa", idEmpresa);
        }
    }*/

    @Override
    public List<ConvocatoriaForTableDTO> getConvocatorias(Integer idEmpresa){
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        if (empresa.isPresent()) {
            return convocatoriaRepository.findAllDtoByEmpresaId(empresa.get());
        }else{
            throw new NotFoundException("Empresa", idEmpresa);
        }
    }
    public EmpresaDTO toDTO(Empresa empresa){
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setId(empresa.getId());
        empresaDTO.setNombre(empresa.getNombre());
        empresaDTO.setUbicacion(empresa.getUbicacion());
        empresaDTO.setImagen(empresa.getImagen());
        empresaDTO.setNit(empresa.getNit());
        empresaDTO.setUsuario(empresa.getUsuario());
        empresaDTO.setContrasenia(empresa.getContrasenia());
        empresaDTO.setRol(empresa.getRol());
        return empresaDTO;
    }
    public Empresa toEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = new Empresa();
        empresa.setId(empresaDTO.getId());
        empresa.setNombre(empresaDTO.getNombre());
        empresa.setUbicacion(empresaDTO.getUbicacion());
        empresa.setImagen(empresaDTO.getImagen());
        empresa.setNit(empresaDTO.getNit());
        empresa.setUsuario(empresaDTO.getUsuario());
        empresa.setContrasenia(empresaDTO.getContrasenia());
        empresa.setRol(empresaDTO.getRol());
        return empresa;
    }

}
