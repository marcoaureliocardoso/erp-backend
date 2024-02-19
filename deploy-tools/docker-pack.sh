./mvnw clean install 
docker build -t sead/erp-backend .
docker save -o ../sead_erp-backend.jar sead/erp-backend