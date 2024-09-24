package pe.edu.cibertec.rueditas_backend.service;

import pe.edu.cibertec.rueditas_backend.dto.RueditaRequestDTO;

import java.util.List;

public interface RueditaService {
    List<String> findByPlaca (RueditaRequestDTO rueditaRequestDTO);
}
