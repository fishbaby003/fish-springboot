**Write a HTTP-based back-end which stores and provides**

**betting offer's stakes for different customers, with the**

**capability to return the highest stakes on a betting offer**

**Nonfunctional Requirements**

\- There is no persistence and the application needs to be able to run indefinitely without crashing. 

\- The service needs to be able to handle a lot of simultaneous requests, so bear in mind the memory

and CPU resources at your disposal. 

\- You can use frameworks, such as Spring Boot to implement the REST methods. 

**Functional Requirements**

You have to implement the following 3 methods :

**1. Get session**

Get or create a session which is valid for 10 minutes. Multiple method invocations in less than 10 mins

should return same session. 

**Request**: GET /<customerid>/session

**Response**: <sessionkey>

<customerid>: int

<sessionkey>: a “reasonably” unique - letters and digits only string identifying the session (valid for 10

minutes)

**Example**: http://localhost:8001/1234/session --> QWER12A (Get or create a session for the customer

1234)

**2. Post a customer’s stake on a betting offer**

\- Only requests with valid session keys will be processed

\- The response is empty

\- This method can be called several times per customer and betting offer. This means that a customer

can post more stakes for the same betting offer. 

**Request**: POST /<betofferid>/stake?sessionkey=<sessionkey>

**Request body**: <stake>

**Response**: (empty)

<stake>: int

<betofferid>: int, id of a betting offer

<sessionkey>: a session key retrieved from the "create a session" function

**Example**: POST

http://localhost:8001/888/stake?sessionkey=QWER12A with post body: 4500 (4500 is the stake for

betting offer id 888 for the customer with session QWER12A)

**3. Get a high stakes list for a betting offer**

\- Retrieve the high stakes for a specific betting offer. 

\- The result is a list sorted by descending order. The values are separated using commas. 

\- We are interested in the top 20 stakes on the betting offer and only the highest stake per betting

offer counts for a specific customer: a customer id can only appear at most once in the returned list. 

\- If there are no submitted stakes for a betting offer the response for calling this method will be an

empty string. 

**Request**: GET /<betofferid>/highstakes

**Response**: CSV of <customerid>=<stake>

<betofferid>: int, id of a betting offer

<stake>: int

<customerid>: int

**Example**: http://localhost:8001/888/highstakes ->1234=4500,57453=1337 (For betting offer 888, 

customer 1234 posted the stake 4500 and customer 57453 posted the stake 1337)

**Notes**

1. when a customer's session expires, the stakes posted with that session should not be deleted. 

2. pay attention to code structure, threading and understanding of the problem. Keep it stupid simple. 

3. implementation needs to be delivered as an archive containing the following: compiled version in

an executable jar file in the root folder and readme file with thoughts around the chosen solution
