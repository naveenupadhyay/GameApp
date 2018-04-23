## This GameApp is built using websockets and stomp messaging (http://www.baeldung.com/websockets-spring).

##Websockets because :
  Http connection is on a request response model and due to the interactiveness of a game application a fully duplex channel better serves the requirement.

The code is broken down into Game Server logic and auxiliary classes.
Auxiliary classes have :
 db support using Spring Data JPA
 Event driven approach using event dispatcher mechanism. This decouples the entity sending the event(TableService) to the entity handling the event(Event Handler) - all routed by the dispatcher..

## Game Server :
 It alows a player to :
   - Join table.
   - disconnect.
   
   Authentication is managed by login.
   
   
## Requirements
- Apache Maven
- JAVA 8

### How To setup
- clone this project in local
- mvn clean package
- mvn spring-boot:run
- http://localhost:8081/login.html
 
   
- Organization Id: com.jungleegames
- Project Name: GameApp
- Project Version: 1.0-SNAPSHOT

