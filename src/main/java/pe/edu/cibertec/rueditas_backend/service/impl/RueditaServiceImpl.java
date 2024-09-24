package pe.edu.cibertec.rueditas_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas_backend.dto.RueditaRequestDTO;
import pe.edu.cibertec.rueditas_backend.service.RueditaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class RueditaServiceImpl implements RueditaService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public List<String> findByPlaca(RueditaRequestDTO rueditaRequestDTO) {
        List<String> lista = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = reader.readLine()) != null){
                String[] dato = linea.split(";");
                if(rueditaRequestDTO.placa().equals(dato[0])){
                    lista = List.of(dato[1],
                            dato[2],
                            dato[3],
                            dato[4],
                            dato[5]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
