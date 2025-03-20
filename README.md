# ETEREA.programa-dia-service

[![ETEREA.programa-dia-service CI](https://github.com/ETEREA-services/ETEREA.programa-dia-service/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/ETEREA-services/ETEREA.programa-dia-service/actions/workflows/maven.yml)

## Descripción del Proyecto
ETEREA.programa-dia-service es un servicio de backend desarrollado en Java utilizando Spring Boot. Este servicio gestiona la lógica de negocio relacionada con el programa del día, incluyendo la gestión de vouchers, reservas y clientes.

## Requisitos Previos
- Java 21
- Maven 3.9.9
- Docker (opcional, para despliegue en contenedores)

## Instalación
1. Clonar el repositorio:
   ```sh
   git clone https://github.com/ETEREA-services/ETEREA.programa-dia-service.git
   cd ETEREA.programa-dia-service
   ```
2. Construir el proyecto con Maven:
   ```sh
   ./mvnw clean install
   ```

## Ejecución
Para ejecutar la aplicación localmente, usar el siguiente comando:
```sh
./mvnw spring-boot:run
```

## Pruebas
Para ejecutar las pruebas, usar el siguiente comando:
```sh
./mvnw test
```

## Despliegue
Para construir y ejecutar la imagen Docker, usar los siguientes comandos:
```sh
# Construir la imagen Docker
docker build -t eterea/programa-dia-service .

# Ejecutar el contenedor Docker
docker run -p 8080:8080 eterea/programa-dia-service
```

## Contribución
Para contribuir al proyecto, por favor seguir los siguientes pasos:
1. Hacer un fork del repositorio.
2. Crear una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realizar los cambios necesarios y hacer commit (`git commit -am 'Agregar nueva funcionalidad'`).
4. Hacer push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Crear un Pull Request.

## Licencia
Este proyecto está licenciado bajo la Licencia Apache 2.0. Ver el archivo [LICENSE](LICENSE) para más detalles.
