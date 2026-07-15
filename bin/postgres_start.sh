docker run -d --name pg-docker `
-e POSTGRES_PASSWORD=postgres `
-e POSTGRES_DB=local `
-p 5435:5432 `
postgres:17.2