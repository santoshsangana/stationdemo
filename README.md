This is a demo application  which is a REST service, built with Spring Boot, to allow end-users to pull station data, 
add a new station and update a station. 

This application will the follwing functions and are exposed through REST api
1. findAllStations               http://localhost:8080/station/all
2. findStationByName             http://localhost:8080/station/name/{name}
3. findStationById               http://localhost:8080/station/{id}
4. find StationByHdEnabled       http://localhost:8080/station/hdenabled/{isEnabled}
5. CreateStation                 http://localhost:8080/station/create 
6. DeleteStation                 http://localhost:8080/station/delete/{id}

The Swagger UI documentation can be accessed at http://localhost:8080/swagger-ui.html

The Actuator end points can be accessed at http://localhose:8080/actuator/
