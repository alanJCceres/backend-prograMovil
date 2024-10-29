Requisitos para ejecutar el proyecto:
- Java 21
- gradle
- xampp en el puerto 3306
- tener una base de datos llamada proyecto_movil

Para ejecutar el proyecto:
- clonar el repositorio git clone https://github.com/alanJCceres/backend-prograMovil.git
- en la raiz del repositorio ejecutar en la terminar ./gradlew build
- Tener corriendo xampp el puerto 3306 con el usuario root sin contreseña y con la base de datos creada llamada proyecto_movil. El Script de la BD esta en el respositorio
- Ejecutar el proyecto spring
- Finalmente hacer prueba del correcto funcionamiento haciendo llamado al endpoint: GET localhost:8080/holaMundo
