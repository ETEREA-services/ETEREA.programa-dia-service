package eterea.programa.dia.service.client.core;

import eterea.programa.dia.service.domain.dto.VoucherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.OffsetDateTime;
import java.util.List;

@FeignClient("core-service/api/core/voucher")
public interface VoucherClient {

    @GetMapping("/today/{user}")
    List<VoucherDto> findAllByUserToday(@PathVariable String user);

    @GetMapping("/fechaServicio/{fechaServicio}/{soloConfirmados}/{porNombrePax}")
    List<VoucherDto> findAllByFechaServicio(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime fechaServicio,
                                            @PathVariable Boolean soloConfirmados, @PathVariable Boolean porNombrePax);

    @GetMapping("/byNumeroVoucher/{numeroVoucher}")
    VoucherDto findByNumeroVoucher(@PathVariable String numeroVoucher);

    @GetMapping("/{voucherId}")
    VoucherDto findByVoucherId(@PathVariable Long voucherId);

}
