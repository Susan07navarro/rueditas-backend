package pe.edu.cibertec.rueditas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditas_backend.dto.RueditaRequestDTO;
import pe.edu.cibertec.rueditas_backend.dto.RueditaResponseDTO;
import pe.edu.cibertec.rueditas_backend.service.RueditaService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/inicio")
public class RueditaController {
    @Autowired
    private RueditaService ruedaService;
    @PostMapping("")
    public ResponseEntity<RueditaResponseDTO> findByPlaca (@RequestBody RueditaRequestDTO rueditaRequestDTO){
        try{
            List<String> datos = ruedaService.findByPlaca(rueditaRequestDTO);
            if(datos == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            RueditaResponseDTO responseDTO = new RueditaResponseDTO(
                    datos.get(0),
                    datos.get(1),
                    Integer.parseInt(datos.get(2)),
                    BigDecimal.valueOf(Double.parseDouble(datos.get(3))),
                    datos.get(4)
            );
            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
}
