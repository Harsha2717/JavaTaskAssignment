# flights-api

## Local setup

### Required dependencies

   1. [JDK17](https://www.oracle.com/java/technologies/downloads/#java17)
   2. [Maven-3.9.6](https://maven.apache.org/download.cgi)
   3. [Docker-4.25.2](https://docs.docker.com/desktop/install/windows-install/)
   4. [Postgres-16.1](./docker-compose.yaml)
   5. [MongoDB-5.0.23](./docker-compose.yaml)
   6. [RedisDB-7.2.3](./docker-compose.yaml)
   7. [Intellij IDE-2023.2](https://www.jetbrains.com/idea/download/other.html)

### IDE Setup

   1. Download [code style xml](https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml)
   2. click on ```ctrl+alt+s```, Select ```Editor``` --> ```Code Style``` --> ```Java```
   3. Click on Settings Icon, beside the Scheme --> ```Import Scheme``` --> ```Intellij IDEA Code Style XML```
   4. Select above downloaded file path

### Running Application in Local

   1. Open Terminal and run ```mvn clean install``` to install all the required dependencies.
   2. In Terminal run ```docker-compose up```
   3. Run the Application main class

