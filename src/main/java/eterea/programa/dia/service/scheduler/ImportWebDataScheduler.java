package eterea.programa.dia.service.scheduler;

import eterea.programa.dia.service.service.facade.ProgramaDiaService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@ConditionalOnProperty(name = "app.testing", havingValue = "false", matchIfMissing = true)
public class ImportWebDataScheduler {

    private final ProgramaDiaService service;

    public ImportWebDataScheduler(ProgramaDiaService service) {
        this.service = service;
    }

    @Scheduled(cron = "0 30 * * * *")
    public void importManyCompletedFromWebScheduled() {
        service.importManyCompletedFromWeb();
    }

}
