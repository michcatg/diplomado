# coordlib-service
Microservicio en Java creado com práctica del diplomado
Estos son otros cambios desde el feat 1 feb

## Estrategia de ramas
El flujo de trabajo par el desarrollo organizado y colaborativo del presente proyecto sigue la siguiente estrategia de ramas:

### Ramas principales
* main
  * Contiene el código en producción y solo se actualiza con cambios estables, revisados y probados
* dev
  * Integra cambios de las features desarrolladas antes de fusionarlos a main

### Ramas de trabajo
* feature/nueva-feature
  * Desarrolla nuevas funcionalidades (una por cada funcionalidad distinta)
  * Creada a partir de dev y se integra a dev una vez completada la funcionalidad (Pull Request)
* hotfix/arreglo
  * Corrige errores de main y se crea desde main

Cambios 2 para probar el listener
