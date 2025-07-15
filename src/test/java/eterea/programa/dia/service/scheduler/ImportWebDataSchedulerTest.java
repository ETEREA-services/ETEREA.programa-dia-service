package eterea.programa.dia.service.scheduler;

import eterea.programa.dia.service.service.facade.ProgramaDiaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ImportWebDataSchedulerTest {
    @Test
    void importManyCompletedFromWebScheduled_callsService() {
        ProgramaDiaService service = Mockito.mock(ProgramaDiaService.class);
        ImportWebDataScheduler scheduler = new ImportWebDataScheduler(service);
        scheduler.importManyCompletedFromWebScheduled();
        Mockito.verify(service).importManyCompletedFromWeb();
    }
}
