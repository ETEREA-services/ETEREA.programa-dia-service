package eterea.programa.dia.service.controller.facade;

import eterea.programa.dia.service.domain.dto.ProgramaDiaDto;
import eterea.programa.dia.service.exception.ProgramaDiaException;
import eterea.programa.dia.service.service.facade.ProgramaDiaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;

@RestController
@RequestMapping({"/api/programa-dia/programaDia", "/programaDia"})
public class ProgramaDiaController {

    private final ProgramaDiaService service;

    public ProgramaDiaController(ProgramaDiaService service) {
        this.service = service;
    }

    @GetMapping("/fechaServicio/{fechaServicio}/{soloConfirmados}/{porNombrePax}")
    public ResponseEntity<ProgramaDiaDto> findAllByFecha(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime fechaServicio,
            @PathVariable Boolean soloConfirmados, @PathVariable Boolean porNombrePax) {
        return new ResponseEntity<>(
                service.findAllByFechaServicio(fechaServicio, soloConfirmados, porNombrePax), HttpStatus.OK);
    }

    @GetMapping("/voucher/{voucherId}")
    public ResponseEntity<ProgramaDiaDto> findByVoucherId(@PathVariable Long voucherId) {
        try {
            return new ResponseEntity<>(service.findByVoucherId(voucherId), HttpStatus.OK);
        } catch (ProgramaDiaException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/importOneFromWeb/{orderNumberId}")
    public ResponseEntity<Void> importOneFromWeb(@PathVariable Long orderNumberId) {
        service.importOneFromWeb(orderNumberId, null);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/importManyCompletedFromWeb")
    public ResponseEntity<Void> importManyCompletedFromWeb() {
        service.importManyCompletedFromWeb();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // @Scheduled(cron = "0 30 * * * *")
    public ResponseEntity<Void> importManyCompletedFromWebScheduled() {
        service.importManyCompletedFromWeb();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
