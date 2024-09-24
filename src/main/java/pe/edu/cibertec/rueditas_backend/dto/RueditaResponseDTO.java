package pe.edu.cibertec.rueditas_backend.dto;

import java.math.BigDecimal;

public record RueditaResponseDTO(String marca, String modelo, Integer numeroAsiento,
                                 BigDecimal precio, String color) {
}
