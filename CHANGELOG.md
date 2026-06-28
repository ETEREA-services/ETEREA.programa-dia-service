## [1.0.2] - 2026-06-28
- chore: Actualización de Spring Boot Starter Parent de 4.0.6 a 4.1.0
- chore: Actualización de Spring Cloud de 2025.1.0 a 2025.1.2
- chore: Actualización de springdoc-openapi de 3.0.2 a 3.0.3
- fix: Corrección de formato de fecha ISO 8601 en DTOs (Z → XX) para ClienteDto, ClienteMovimientoDto, ReservaDto, VoucherDto

## [1.0.1] - 2026-06-06
- fix: Mejora de formato en logs de depuración en importOneFromWeb (separadores \n\n)
- docs: Actualización de diagramas Mermaid: agregado flujo importManyCompletedFromWeb y DTOs faltantes (EmpresaDto, TrackDto, CuentaDto, ReservaContextDto)

## [1.0.0] - 2026-05-30
- feat: Actualización de Spring Boot Starter Parent de 3.5.8 a 4.0.6 (major)
- feat: Actualización de Spring Cloud de 2025.0.0 a 2025.1.0
- feat: Actualización de springdoc-openapi de 2.8.10 a 3.0.2 (major)
- feat: Nuevo test dependency spring-boot-starter-webmvc-test con relocalización de WebMvcTest
- feat: Refactor de todos los DTOs: @Data reemplazado por @Getter/@Setter/@Builder/@NoArgsConstructor/@AllArgsConstructor
- feat: Refactor de controladores y servicios: constructores manuales reemplazados por @RequiredArgsConstructor
- feat: Refactor de ResponseEntity: uso de helpers (ResponseEntity.ok()) en lugar de new ResponseEntity<>()
- chore: Eliminación de dependencia spring-boot-starter-aop
- chore: Eliminación de configuración executable=true en spring-boot-maven-plugin
- chore: Actualización de commons-lang3 a 3.20.0
- chore: Nueva dependencia commons-fileupload 1.6.0 en dependencyManagement
- chore: Actualización de GitHub Actions a checkout@v6, setup-java@v5, cache@v5, docker/*@v4/v6/v7, deploy-pages@v5
- fix: Simplificación del path de artefacto en pipeline de documentación

## [0.7.0] - 2026-01-06
- chore: Update Java version to 25
- chore: Update Spring Boot Starter Parent to 3.5.8
- feat: Change ImportWebDataScheduler cron from hourly to every 10 minutes

## [0.6.1] - 2025-09-21
- chore: Update Spring Boot Starter Parent to 3.5.6
- chore: Update springdoc-openapi-starter-webmvc-ui to 2.8.10
- refactor: Replace manual constructor with @RequiredArgsConstructor in ProgramaDiaService

## [0.6.0] - 2025-08-05
 - feat: Migración completa de Eureka a Consul como discovery service (bootstrap.yml, pom.xml)
 - feat: Añadido soporte para importación automática de programas completados vía scheduler (ImportWebDataScheduler)
 - feat: Nuevos DTOs y métodos de serialización JSON (ProgramaDiaDto, ReservaContextDto, TrackDto)
 - feat: Añadido deserializador personalizado para OffsetDateTime (OffsetDateTimeDeserializer)
 - fix: Refactor en ProgramaDiaService para mejorar trazabilidad y logging
 - test: Nuevos tests unitarios para servicios, DTOs y utilidades
 - chore: Actualización de Spring Boot Starter Parent a 3.5.4
 - chore: Actualización de endpoints expuestos en actuator (bootstrap.yml)

## [0.5.0] - 2025-07-24
 - feat(config): Migración de Eureka a Consul como discovery service (pom.xml, bootstrap.yml)
 - feat(ci): Integración de análisis SonarCloud y mejoras de caché en GitHub Actions (maven.yml)
 - feat(docker): Instalación de curl en la imagen final de Docker (Dockerfile)
 - chore: Eliminación de Dockerfile.local (ahora solo se usa Dockerfile principal)
 - feat(deps): Añadido commons-lang3 a dependencyManagement (pom.xml)
 - feat(config): Exposición del endpoint `health` en actuator (bootstrap.yml)
 - refactor: Actualización de nombre de proyecto en pom.xml
## [0.4.0] - 2025-07-06
- feat(docs): implementa pipeline de generación de documentación automática
- fix(ci): mejora el script de renderizado de Mermaid en la página de documentación
- fix(docs): corrige la sintaxis de los diagramas Mermaid
- fix(ci): corrige la ruta del artefacto para el despliegue de GitHub Pages

## [0.3.1] - 2025-07-04
- fix: Rehabilitación del proceso automático de facturación.

## [0.3.0] - 2025-07-02
- feat(service): add tracking and re-enable scheduled task

## [0.2.0] - 2025-07-02
- Eliminar temporalmente el Scheduled de Facturación Automática
- chore(deps): update dependencies and improve documentation
- refactor(controller): separate REST endpoint from scheduled task
- feat(dto): add diferenciaWeb field for web price differences
- chore(dependencies): update Spring Boot Starter Parent version to 3.4.1