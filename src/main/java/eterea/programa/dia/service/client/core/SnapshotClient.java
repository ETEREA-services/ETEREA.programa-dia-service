package eterea.programa.dia.service.client.core;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("core-service/api/core/snapshot")
public interface SnapshotClient {
}
