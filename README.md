# Pico y Placa API

API REST para validar placa, fecha y hora contra reglas de “Pico y Placa”.

Diagrama: https://s.icepanel.io/OqVC5HW8JoIDeB/MElW

---

## Prerrequisitos

- Java 21 (JDK instalado y `JAVA_HOME` configurado)
- Maven 3.8+
- Git (opcional)

---

## Generación del artefacto

1.  **Compilar y empaquetar** Desde la raíz del proyecto:

    ```bash
    mvn clean install
    ```
    Esto ejecuta todas las pruebas, genera el JAR en `target/pico-y-placa-api-0.0.1-SNAPSHOT.jar` y lo instala en tu repositorio local.

2.  **(Opcional) Deploy a repositorio remoto**

    Si tienes configurado un repositorio remoto (Nexus, Artifactory, etc.) en tu `pom.xml` o en `settings.xml`, lanza:
    ```bash
    mvn deploy
    ```
    para subir el artefacto.

---

## Estructura de ejecución

Una vez generado el JAR, el proyecto espera encontrar los archivos de configuración en:
config/
└── application.properties

#### Crear la carpeta `config`
En el mismo nivel donde está el JAR, crea el directorio:

```bash
mkdir config
```

Y dentro coloca tu application.properties (o application.yml) con las propiedades del proyecto. Por ejemplo:

```
# config/application.properties

spring.application.name=pico-y-placa-api
spring.profiles.active=prod

# Configuración Pico y Placa...
pico-placa.reglas[0].dia=MONDAY
# … demás reglas y excepciones …
```

# Ejecución

Desde la carpeta donde tengas el JAR y la subcarpeta config/, ejecuta:

```
java -jar pico-y-placa-api-0.0.1-SNAPSHOT.jar \
--spring.config.location=classpath:/,config/application.properties
```
El parámetro --spring.config.location indica a Spring Boot que cargue tu archivo de configuración externo, además de los internos.

Endpoints principales
GET /api/v1/picoPlaca
Parámetros:

placa (String): e.g. ABC1234

fecha (String en formato YYYY-MM-DD)

hora (String en formato HH:mm)

Ejemplo de uso con cURL:

curl "http://localhost:8080/api/v1/picoPlaca?placa=ABC1234&fecha=2025-07-15&hora=07:30"

