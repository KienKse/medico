package ucsal.medico.service;

import ucsal.medico.model.Exame;
import ucsal.medico.repository.ExameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ucsal.medico.controller.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ExameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExameService.class);

    @Autowired // This means to get the bean called exameRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ExameRepository exameRepository;

    public List<Exame> getAll() {
        LOGGER.debug("Obtendo exames");
        return exameRepository.findAll();
    }

    public Exame addNewExame(Exame request) {

        Exame exame = new Exame(request);

        return exameRepository.save(exame);
    }

    public Exame getExameById(Long exameId) {
        return exameRepository.findById(exameId)
                .orElseThrow(() -> new ResourceNotFoundException("EXAME", "id", exameId));
    }

    public void deleteExame(Long carId) {
        Exame exame = getExameById(carId);

        exameRepository.delete(exame);
    }

    // RESOLVE - FIX UPDATE
    public ResponseEntity<Object> updateExame(Exame exameDetails, Long carId) {
        Optional<Exame> exameOptional = exameRepository.findById(carId);

        if(!exameOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        exameDetails.setCodigo(carId);

        exameRepository.save(exameDetails);

        return ResponseEntity.noContent().build();
    }



}