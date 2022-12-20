# Agent-Project
This example app shows how to create a Spring Boot Agent App and CRUD (create, read, update, and delete) its data 

## Getting Started
To install this example application, run the following commands:

git clone https://github.com/racem-cherni/Agent-Project.git 

## Here are some endpoints you can call:

```
http://localhost:8081/api/v1/agents
http://localhost:8081/api/v1/agent
http://localhost:8081/api/v1/{name}
http://localhost:8081/api/v1/{id}
```

### Create an agent

#### create an agent resource

```
POST /api/v1/agent
Accept: application/json
Content-Type: application/json

{"os":"Ubuntu",
"lastKeepAlive":"9999-12-31T23:59:59Z",
"dateAdd":"2022-07-18T07:14:54Z",
"ip":"127.0.0.1",
"name":"customer",
"version":"Wazuhv4.3.8",
"status":"active"}

RESPONSE: HTTP 201 (Created)
```
#### create an agent resource ( name already belongs to another agent)

```
POST /api/v1/agent
Accept: application/json
Content-Type: application/json

{"os":"Ubuntu",
"lastKeepAlive":"9999-12-31T23:59:59Z",
"dateAdd":"2022-07-18T07:14:54Z",
"ip":"127.0.0.1",
"name":"customer",
"version":"Wazuhv4.3.8",
"status":"disconnected"}


RESPONSE: HTTP 500 (Internal Server Error)
Content: agent with name : << cyr-customer-ossec.local >> already exist
```
### Retrieve a  list of agents

```
http://localhost:8081/api/v1/agents

Response: HTTP 200
Content: agent list 
```
### Update an agent resource

#### Update an agent resource (searched name does not exist in DB)

```
PUT /api/v1/test
Accept: application/json
Content-Type: application/json

{"id":"1",
"os":"Ubuntu",
"lastKeepAlive":"9999-12-31T23:59:59Z",
"dateAdd":"2022-07-18T07:14:54Z",
"ip":"127.0.0.1",
"name":"customer",
"version":"Wazuhv4.3.8",
"status":"disconnected"}


RESPONSE: HTTP 500 (Internal Server Error)
Content: agent with name : << test >> does not exist
```
#### Update an agent resource (updated name already belongs to another agent)

```
PUT /api/v1/customer
Accept: application/json
Content-Type: application/json

{"id":"1",
"os":"Ubuntu",
"lastKeepAlive":"9999-12-31T23:59:59Z",
"dateAdd":"2022-07-18T07:14:54Z",
"ip":"127.0.0.1",
"name":"cyr-customer-ossec.local",
"version":"Wazuhv4.3.8",
"status":"disconnected"}


RESPONSE: HTTP 500 (Internal Server Error)
Content: name : <<cyr-customer-ossec.local >> already belongs to another agent
```
#### Update an agent resource (correct)

```
PUT /api/v1/customer
Accept: application/json
Content-Type: application/json

{"id":"1",
"os":"Ubuntu",
"lastKeepAlive":"9999-12-31T23:59:59Z",
"dateAdd":"2022-07-18T07:14:54Z",
"ip":"127.0.0.1",
"name":"customer",
"version":"Wazuhv4.3.8",
"status":"disconnected"}


RESPONSE: HTTP 200 (OK)
```
### Delete an agent
#### Delete an agent (id exist)

```
DELETE /api/v1/1

RESPONSE: HTTP 200 ok
Content : Agent deleted successfully!

```
#### Delete an agent (id doest not exist)

```
DELETE /api/v1/10

RESPONSE: HTTP 404 Not Found
Content : agent with id: '10' does not exist
