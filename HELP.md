# Getting Started

### Documentation
#### Preparation for technical interview.
Below is a task of building a small REST API. The task is meant to be solved within 2-3 hours. The code produced will be used as a starting point for an informal conversation regarding programming in general and discussions about design and architecture.
As such, the objective is to convey ideas around technology choices, your approach to architecture and developing code, not a finished and production ready API. Any cool ideas for further implantation are welcome, but in no way required.
As restraints for the development task, it must be developed in spring boot as a self-contained jar file. Maven must be used as build tool.
Development Task:
Design and build a simple REST API centered around Company and Owner Data entities.
* Company consists of:
• Address
• Phone Number
• CVR
• One or more Owners
• Profitability
* Owner consists of:
• Name
• Address
• CPR

The API should be able to do standard CRUD operations – select a few to implement.
The profitability field is collected from a provided API specification (company-profitablity.yaml). The service does not exist in the real world but show how to connect to such a service when given a specification. Feel free to mock the service response.
The API should be able to both support persisting data (a mocked repository or likewise is fine).
You do not need to implement persistence but think about what choices you would make regarding technology and why.
You do not need to implement security but think about what choices you would make regarding technology and why.
In the integration chapter we use hexagonal architecture. It is not required for this task, but thoughts around a possible implementation using that architecture style for this API will be appreciated.
NOTE: Feel free to use AI tools but DO tell where and why.
When the task is completed, please zip the project and return it by mail or upload the code to a GitHub repository and get back to us with a link to that.

#### components used
* org.springframework.boot version v.3.2.1: spring-boot-starter-data-jpa, spring-boot-starter-web
* H2 DB (in mem) with bootstrap demo data from import.sql
* Lombok (minimize boilerplate code i classes)
* maven with maven wrapper 3.9.5
* java 17

#### build and run
* navigate to root dir
* ./mvnw clean install
* java -jar target/partner-0.0.1-SNAPSHOT.jar

#### example using the REST api with curl
```
curl --location --request GET 'http://localhost:8080/companies/2233441'
```
```
curl --location --request POST 'http://localhost:8080/companies' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "address": "CA2",
  "phonenumber": "+45 11 22 33 44",
  "cvr": "2233442",
  "owners": [
  {
  "name": "Navn3",
  "address": "A3",
  "cpr": "1806660583"
  },
  {
  "name": "Navn4",
  "address": "A4",
  "cpr": "1806660584"
  }
  ]
  }' 
```
```
curl --location --request PUT 'http://localhost:8080/companies/2233442' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "address": "CA2",
  "phonenumber": "+45 11 22 33 44",
  "cvr": "2233442",
  "owners": [
  {
  "name": "Navn33",
  "address": "A3",
  "cpr": "1806660583"

        }
  ]
  }'
```
```
curl --location --request DELETE 'http://localhost:8080/companies/2233441' \
    --header 'Content-Type: application/json' \
    --data-raw ''
```
```
curl --location --request GET 'http://localhost:8080/companies/2233441'
```
