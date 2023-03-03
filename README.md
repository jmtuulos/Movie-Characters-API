# Movie-Characters-API

\
Spring Boot REST API service using Hibernate with Postgres database.


- CI workflow (Docker build and push):
https://github.com/jmtuulos/Movie-Characters-API/actions/workflows/ci.yml

- Swagger (API documentation and testing):
http://localhost:8080/swagger-ui/index.html#/

- Dockerfile included in the project root.  
   

## Controllers and API routes

### movie-controller  
| Method | Path                           | Description                   |
|:-------|:-------------------------------|:------------------------------|
| DELETE | /api/v1/movies/{id}            | Delete a movie                |
| GET    | /api/v1/movies/{id}            | Get a movie by id             |
| GET    | /api/v1/movies                 | Get all movies                |  
| GET    | /api/v1/movies/{id}/characters | Get all characters in a movie |  
| PATCH  | /api/v1/movies/{id}/characters | Update characters in a movie  |  
| POST   | /api/v1/movies                 | Add a movie                   | 
| PUT    | /api/v1/movies/{id}            | Update a movie                |  

### franchise-controller
| Method | Path                               | Description                         |
|:-------|:-----------------------------------|:------------------------------------|
| DELETE | /api/v1/franchises/{id}            | Delete franchise by id              | 
| GET    | /api/v1/franchises/{id}            | Get franchise by id                 |  
| GET    | /api/v1/franchises                 | Get all franchises                  | 
| GET    | /api/v1/franchises/{id}/movies     | Get all movies from a franchise     | 
| GET    | /api/v1/franchises/{id}/characters | Get all characters from a franchise |  
| PATCH  | /api/v1/franchises/{id}/movies     | Update movies in a franchise        |  
| POST   | /api/v1/franchises                 | Add a new franchise                 | 
| PUT    | /api/v1/franchises/{id}            | Update a franchise                  |  

### character-controller
| Method | Path                    | Description           |
|:-------|:------------------------|:----------------------|
| DELETE | /api/v1/characters/{id} | Delete a character    |  
| GET    | /api/v1/characters/{id} | Get a character by id |  
| GET    | /api/v1/characters      | Get all characters    |  
| POST   | /api/v1/characters      | Add a character       |  
| PUT    | /api/v1/characters/{id} | Update a character    | 

## Contributors
- Juha Tuulos & Jetro Saarti


