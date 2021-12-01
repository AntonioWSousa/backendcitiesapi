[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/AntonioWSousa)](https://github.com/AntonioWSousa)
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/AntonioWSousa/backendcitiesapi/blob/main/LICENSE) 

# Projeto Cities API

#### Este é um projeto de uma API REST criado para realização de consultas de todos os países do mundo, e também de todos os estados e cidades do Brasil.


# Tecnologias utilizadas

- Windows
- Power Shell
- Spring Tool Suite
- Java 8
- Docker
- PostgreSQL
- Postman
- Git
- Heroku CLI

# Dependencies

- Spring Web
- Spring Data JPA
-  PostgreSQL Driver

#Properties

- [Spring](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
- [JDBC](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)


# DataBase

- [Postgres Docker Hub](https://hub.docker.com/_/postgres)
- Comando para baixar e criar o container do Postgres para o projeto
- Para inserir os comandos para criar o container do Postgres, foi utilizado o Power Shell no modo administrador e o Docker Desktop startado

```
docker pull postgres
```
```
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

# Configuração e importação das querys dentro do container Postgres:

- Agradecimentos especiais para Chinnon Santos pela disponibilização dos dados SQL para popular tabelas dentro da API
- [Dados SQL para popular as tabelas](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```
git clone git@github.com:chinnonsantos/sql-paises-estados-cidades.git
```
```
cd .\sql-paises-estados-cidades\PostgreSQL\
```
```
docker start cities-db
```
```
docker ps
```
```
docker run -it --rm --net=host -v ${PWD}:/tmp postgres /bin/bash
```
```
cd tmp/
```
```
ls
```
```
psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
```
```
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
```
```
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql
```
```
psql -h localhost -U postgres_user_city cities
```
```
\d pais;
```
```
select * from pais;
```
### List Country - Find All
```
http://localhost:8080/countries
```

### Pageable Country - Find All
```
http://localhost:8080/countries?page=0&size=10&sort=name,asc
```

### Country - Find by ID
```
http://localhost:8080/countries/1
```
### State - Find All
```
http://localhost:8080/states
```
### State - Find All
```
http://localhost:8080/cities
```
```
CREATE EXTENSION cube; 
```
```
CREATE EXTENSION earthdistance;
```

### Query Earth Distance
```
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```
```
select lat_lon from cidade where id=5254;
```

### Cube
```
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```
```
http://localhost:8080/distances/by-points?from=4929&to=5254
```
```
http://localhost:8080/distances/by-cube?from=4929&to=5254
```
### Heroku
```
heroku create
```
```
git remote -v
```
```
git push heroku main
```
```
heroku addons:create heroku-postgresql
```
```
cd .\sql-paises-estados-cidades\PostgreSQL\
```
```
docker start cities-db
```
```
docker ps
```
```
docker run -it --rm --net=host -v ${PWD}:/tmp postgres /bin/bash
```
```
cd tmp/
```
```
ls
```
```
psql -h host -U user database -f /tmp/pais.sql
```
```
psql -h host -U user database -f /tmp/estado.sql
```
```
psql -h host -U user database -f /tmp/cidade.sql
```
```
psql -h host -U user database
```
```
CREATE EXTENSION cube; 
```
```
CREATE EXTENSION earthdistance;
```

#Utilização da API no Postman ou no browser

- [Países do mundo](https://shrouded-sierra-80518.herokuapp.com/countries)
- [Países do mundo por ID](https://shrouded-sierra-80518.herokuapp.com/countries/1)
- [Estados do Brasil](https://shrouded-sierra-80518.herokuapp.com/states)
- [Estados do Brasil por ID](https://shrouded-sierra-80518.herokuapp.com/states/1)
- [Cidades do Brasil](https://shrouded-sierra-80518.herokuapp.com/cities)
- [Cidades do Brasil por ID](https://shrouded-sierra-80518.herokuapp.com/cities/1)
- [Distância por metros entre cidades](https://shrouded-sierra-80518.herokuapp.com/distances/by-cube?from=4929&to=5254)
- [Distância por milhas entre cidades](https://shrouded-sierra-80518.herokuapp.com/distances/by-points?from=4929&to=5254)





