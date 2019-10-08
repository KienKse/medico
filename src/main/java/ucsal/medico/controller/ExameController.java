package ucsal.medico.controller;

import ucsal.medico.model.Exame;
import ucsal.medico.service.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController    // This means that this class is a Controller
@RequestMapping("/api") // This means URL's start with /api (after Application path)
public class ExameController {

    @Autowired
    private ExameService exameService;

    // Get ALL - Exame
    @GetMapping("/all")
    public List<Exame> getAll() {
        return exameService.getAll();
    }

    // Add Exame
    // @RequestMapping(path = "/add", method = RequestMethod.POST)
    @PostMapping("/add")
    public Exame addNewExame(@Valid @RequestBody Exame request) {
        return exameService.addNewExame(request);
    }

    // Get - Exame
    @GetMapping("/exame/{id}")
    public @ResponseBody
    Exame getExameById(@PathVariable(value = "id") Long carId) {
        return exameService.getExameById(carId);
    }

    // Delete - Exame
    @DeleteMapping("/exame/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteExame(@PathVariable(value = "id") Long carId) {
        Exame exame = exameService.getExameById(carId);
        exameService.deleteExame(carId);

        return ResponseEntity.ok().build();
    }

    // Update Exame
    @PutMapping("/upd/{id}")
    public ResponseEntity<Exame> updateExame(@RequestBody Exame exame, @PathVariable Long id){

        Optional<Exame> exameOptional = Optional.ofNullable(exameService.getExameById(id));

        if (!exameOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        exameService.updateExame(exame, id);

        return ResponseEntity.noContent().build();
    }

}

