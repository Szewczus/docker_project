//budowanie obrazu:
docker build -t sample_docker_app/main_app .  

//tworzenie kontenera opcja -d to detached ukrywa linie polceń z dockera
docker run -d -p 8080:8080 sample_docker_app/main_app:latest

//Run the Docker Registry:
//Start a Docker registry container
docker run -d -p 5000:5000 --name registry registry:2
//add tag to image:
docker tag sample_docker_app/main_app:latest localhost:5000/sample_docker_app/main_app:latest
//push image to registry:
docker push localhost:5000/sample_docker_app/main_app:latest
//check on this page which images we have on registry
http://localhost:5000/v2/_catalog
---------------------------------------------

//run container from main_app_compose.yml -> uruchamia obraz na kontenerze
docker-compose -f .\main_app_compose.yml up -d 
-----------------------------------------------
//1. create main_app on docker hub in https://hub.docker.com/repositories/ewa1234
docker tag sample_docker_app/main_app:latest ewa1234/main_app:latest
docker push ewa1234/main_app:latest 
//stworzenie i uruchomienie kontenera z pliky yml
docker-compose -f .\db_compose.yml up -d
