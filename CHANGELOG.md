## [0.4.0] - 2025-07-15
- feat: Suspendida temporalmente la facturación automática (commit 3fe4351)
- feat(tracking): Propagación de X-Request-ID en llamadas Feign (commit 3b80204)
- fix(ci): Mejoras en el script de renderizado de Mermaid y documentación automática (ad3c48f, f2772d8)
- chore(deps): Actualización a Spring Boot Starter Parent 3.5.3 y Spring Cloud 2025.0.0 (pom.xml)
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