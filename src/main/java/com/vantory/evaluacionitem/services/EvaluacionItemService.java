package com.vantory.evaluacionitem.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vantory.criterioEvaluacion.CriterioEvaluacion;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.evaluacion.Evaluacion;
import com.vantory.evaluacionitem.EvaluacionItem;
import com.vantory.evaluacionitem.dtos.EvaluacionItemCreateDTO;
import com.vantory.evaluacionitem.dtos.EvaluacionItemResponseDTO;
import com.vantory.evaluacionitem.dtos.EvaluacionItemUpdateDTO;
import com.vantory.evaluacionitem.mappers.EvaluacionItemMapper;
import com.vantory.evaluacionitem.repositories.EvaluacionItemRepository;
import com.vantory.utils.UserEmpresaService;
import com.vantory.validator.EntidadValidatorFacade;
import com.vantory.validator.parametrizacion.constantes.EstadoConstantes;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EvaluacionItemService {
    private final EvaluacionItemRepository evaluacionItemRepository;
    private final UserEmpresaService userEmpresaService;
    private final EvaluacionItemMapper evaluacionItemMapper;
    private final EntidadValidatorFacade entidadValidatorFacade;

    public Page<EvaluacionItemResponseDTO>findAll(Pageable pageable){
        Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();
        return evaluacionItemRepository.findByEmpresaId(empresaId, pageable)
                .map(evaluacionItemMapper::toResponseDTO);
    }


    public List<EvaluacionItemResponseDTO> findAllByEvaluacionId(Long evaluacionId){
        Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

        return evaluacionItemRepository.findByEvaluacionIdAndEmpresaId(evaluacionId, empresaId)
                .stream()
                .map(evaluacionItemMapper::toResponseDTO)
                .toList();
    }

    public EvaluacionItemResponseDTO findById(Long evaItemId){
        Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();
        EvaluacionItem evaluacionItem = entidadValidatorFacade.validarEvaluacionItem(evaItemId, empresaId);
        return evaluacionItemMapper.toResponseDTO(evaluacionItem);
    }

    @Transactional
    public EvaluacionItemResponseDTO create(EvaluacionItemCreateDTO evaluacionItemCreateDTO){
        Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();

        Empresa empresa = entidadValidatorFacade.validarEmpresa(empresaId);
        Evaluacion evaluacion = entidadValidatorFacade.validarEvaluacion(evaluacionItemCreateDTO.getEvaluacionId(), empresaId);
        CriterioEvaluacion criterioEvaluacion = entidadValidatorFacade.
                validarCriterioEvaluacion(evaluacionItemCreateDTO.getCriterioEvaluacionId(), empresaId);
        Estado estado = entidadValidatorFacade.validarEstadoGeneral(EstadoConstantes.ESTADO_GENERAL_ACTIVO);

        EvaluacionItem evaItem = evaluacionItemMapper.toEntity(evaluacionItemCreateDTO);
        evaItem.setEmpresa(empresa);
        evaItem.setEvaluacion(evaluacion);
        evaItem.setCriterioEvaluacion(criterioEvaluacion);
        evaItem.setEstado(estado);

        evaluacionItemRepository.save(evaItem);
        return evaluacionItemMapper.toResponseDTO(evaItem);
    }

    @Transactional
    public EvaluacionItemResponseDTO update(Long evaItemId, EvaluacionItemUpdateDTO dto) {
        Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();
        EvaluacionItem item = entidadValidatorFacade.validarEvaluacionItem(evaItemId, empresaId);
        if (dto.getEvaluacionId() != null) {
            Evaluacion evaluacion = entidadValidatorFacade.validarEvaluacion(dto.getEvaluacionId(), empresaId);
            item.setEvaluacion(evaluacion);
        }

        if (dto.getCriterioEvaluacionId() != null) {
            CriterioEvaluacion criterioEvaluacion = entidadValidatorFacade.validarCriterioEvaluacion(dto.getCriterioEvaluacionId(), empresaId);
            item.setCriterioEvaluacion(criterioEvaluacion);
        }

        if (dto.getEstadoId() != null) {
            Estado estado = entidadValidatorFacade.validarEstadoGeneral(dto.getEstadoId());
            item.setEstado(estado);
        }

        evaluacionItemMapper.updateEntityFromDTO(dto, item);

        evaluacionItemRepository.save(item);
        return evaluacionItemMapper.toResponseDTO(item);
    }

    @Transactional
    public void delete(Long evaItemId){
        Long empresaId = userEmpresaService.getEmpresaIdFromCurrentRequest();
        entidadValidatorFacade.validarEvaluacionItem(evaItemId, empresaId);
        evaluacionItemRepository.deleteById(evaItemId);
    }



}
