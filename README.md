# revHousingBackEnd
The RevaHousing application will be used to assist relocated employees in finding available housing from corresponding Revature employees that have property available for rent. All employees in the company can login and register to either create a new post or find a post based off of the Google GeoCoding API. The user that creates a post can get the contact information of another user that is interested in their post by “expressing interest”, and users that are looking to rent a property can bookmark a post to compare different options. Any user will be able to update their profile and logout once their session is complete.
## technologies
* Integrated **Google GeoCoding API** to convert user input into coordinates.
* Hashed user's password with **JBcrypt**.
* Logged routing information with **Log4j**.
* Handled HTTP request and response with **Spring MVC**.
* Enforced logging and authentication of HTTP requests with **Spring AOP**.
* Utilized **Spring ORM** to integrate hibernate and Spring, and enabled Object Relational Mapping communications with the database.
* Persisted Data on a **PostgreSQL** database running on **AWS RDS**.
* Conducted Unit Testing on server-side utilizing **JUnit** and **Mockito**.
