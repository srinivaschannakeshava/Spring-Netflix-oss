# Spring Cloud Fundamanetals
- Spring Cloud Config 
- Spring Cloud Netflix

## Service Discovery
- Why SD?
    - A way for service to register itself
    - A way for service to deregister itself
    - A way for client to find other services
    - A way to check the health of a service and remove un healthy service
### Discovering Services with Spring Cloud
    - Spring Cloud Consul
    - Spring Cloud Zookeeper
    - Spring Cloud Netflix

### Netflix Service Discovery
    - Components 
        -  Eureka Discovery Server
        -  Eureka Service
        -  Eureka Client
    - Steps/Flow
        - Service registers the location,port,service identifier(id) with discovery server
        - Client looks up service location using service identifier
        - Discovery server sends service loaction info
        - client requests service at location
        - service responds with data
    - Discovery server
        - An actively managed registry of service location
        - Source of truth
        - one or more instance
    - Application Service
        - Provides some app functionality
        - Its the receiver of requests
        - a dependency of other service
        - one or more instances
        - user of discovery client
            - register 
            - deregister
    - Application Client
        - call another application to implement its functionality
        - The issuer request
        - user of discovery client
            - uses it to find service location
 ### Configuration in a distributed system
    - Application Configuration server
        - Dedicated ,Dynamic ,Centralized key/value store 
        - Authoritative source
        - Auditing
        - Versioning
        - Cryptography support
    - Spring Cloud Config
        - Config Server
            - HTTP REST Access
            - Output format
                - JSON 
                - Properties
                - YAML
            - Backend Stores
                - GIT
                - SVN
                - File System
            - Configuration Scopes
                - Global scope
                - Profile specific
                - application specific
        - Config Client
            - two ways to configure the application
                - config first
                - discovery first                  

        - Updating the configuration on server
            - once the configuration is updated there is 2 ways of propagating the changes
                - use actuator         
                - spring cloudbus as event listener

 ### Intelligent Routing using Netflix Zuul
    - Gateway Service/API gateway - single point of entry for all service providing
        - Dynamic routing and delivery
        - security and filtering
        - Auditing and logging
        - Request enhancement- ex: addding geolocation info as a part of request
        - load balancing
        - different api's for different clients
    - Filters in Zuul
        - Pre-filter
        - route-filter
        - post-filter
        - error-filter
 ### Client side load-Balancing
    - Server-side
    - Client-side
        - ### Netflix Ribbon

    - Irule implementation for load balancing technique
        - RoundRobbinRule
        - ResponseTime WeightedRule
        - RandomRule
        - ZoneAvoidanceRule
     - Iping Implementation - to check availability of system
        - Dummyping
        - pingUrl
        - NIWSDiscovery ping
 ### Self Healing services with Circuit Breaker
    - Circuit Breaker pattern
    - ### Failure is Inevitable
        - Cascading Failure
            - failure in one system cascades to other system
            - How to solve ?
                - Tolerate Failures
                - Gracefully degrade
                - Limit resources consumed
                    - constrain usage
        - Circuit Breaker Pattern
            - Used to detect failures and encapsulate logic to prevent a failure to reoccur constantly
    - Netflix Hystrix
        - Implements circuit breaker pattern
        - Wraps calls and watches for failures
            - 10 sec rolling window
            - 20 request volume
            - >=50% error rate
        - waits and tries a single request after 5 sec
        - Fallback
        - Protects resources from being overloaded
