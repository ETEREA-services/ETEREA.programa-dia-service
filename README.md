# ETEREA.programa-dia-service

**Versión:** 0.6.1
**Fecha de lanzamiento:** 2025-09-21

[![ETEREA.programa-dia-service CI](https://github.com/ETEREA-services/ETEREA.programa-dia-service/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/ETEREA-services/ETEREA.programa-dia-service/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-24-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-green.svg)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.0.0-blue.svg)](https://spring.io/projects/spring-cloud)
[![Maven](https://img.shields.io/badge/Maven-3.9.9-orange.svg)](https://maven.apache.org/)
[![Docker](https://img.shields.io/badge/Docker-✓-blue.svg)](https://www.docker.com/)
[![License](https://img.shields.io/badge/License-Apache%202.0-yellow.svg)](https://opensource.org/licenses/Apache-2.0)

## Cambios recientes

- Actualización de Spring Boot Starter Parent a 3.5.6.
- Actualización de springdoc-openapi-starter-webmvc-ui a 2.8.10.
- Refactor en ProgramaDiaService para usar @RequiredArgsConstructor.

## Descripción del Proyecto
ETEREA.programa-dia-service es un servicio de backend desarrollado en Java utilizando Spring Boot. Este servicio gestiona la lógica de negocio relacionada con el programa del día, incluyendo la gestión de vouchers, reservas, clientes y manejo de diferencias en precios web.

## Características Principales
- Gestión de programas del día
- Manejo de diferencias en precios web
- Importación automática de programas completados
- API REST para integración con otros servicios
- Documentación automática con GitHub Pages y Wiki
- Sistema de logs mejorado
-- Integración con Spring Cloud y Consul

## Requisitos Previos
- Java 24
- Maven 3.9.9
- Docker (opcional, para despliegue en contenedores)

## Configuración y Despliegue
1. Clonar el repositorio
2. Configurar las variables de entorno necesarias
3. Ejecutar `mvn clean install`
4. Para desarrollo local: `mvn spring-boot:run`
5. Para producción: usar el Dockerfile proporcionado

## Diagramas y documentación

Los diagramas Mermaid (`architecture.mmd`, `data-model.mmd`, `sequence-flow.mmd`) están actualizados a la fecha del release.

## Documentación
- [Documentación de API](https://eterea-services.github.io/ETEREA.programa-dia-service/)
- [Wiki del Proyecto](https://github.com/ETEREA-services/ETEREA.programa-dia-service/wiki)
- [Guía de Desarrollo](docs/development-guide.md)

## Contribución
1. Fork el repositorio
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## Licencia
Este proyecto está bajo la Licencia Apache 2.0 - ver el archivo [LICENSE](LICENSE) para más detalles.

## Contacto
Daniel Quinteros - [@dqmdz](https://github.com/dqmdz)

Link del Proyecto: [https://github.com/ETEREA-services/ETEREA.programa-dia-service](https://github.com/ETEREA-services/ETEREA.programa-dia-service)