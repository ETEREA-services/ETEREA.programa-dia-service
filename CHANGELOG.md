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