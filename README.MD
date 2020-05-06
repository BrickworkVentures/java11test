mvn clean package dockerfile:build
docker-compose up
curl localhost:1234/customthings
curl localhost:1234/things