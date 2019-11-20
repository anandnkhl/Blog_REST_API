This Java Maven projct is a RESTful API with GET, POST, DELETE and PUT functionality for a Blog.

To run this project Prerequisite:
    <br/> 	- Eclipse IDE for Java EE or any Java IDE with Apache Maven support.
    <br/> 	- MySQL 5.x
    <br/> 	- MySQL Workbench or any other clients to access MySQL database
    <br/> 	- Postman or any other REST Clients
    
 Create A DB in MySQl <b>"CREATE DATABASE user_db;"</b>

 In the file "src\main\resources\application.properties" set your MySQL user and password
 edit:  spring.datasource.username= <your MySQL user>
 edit:  spring.datasource.password= <your MySQL password>

 Run the file "src\main\java\com\anandnkhl\blog_rest_API\App.java"

 Once the Application is running use Postman or cURL(on CMD) for GET, POST, PUT, DELETE
 
 <b>Create Blog:</b>
 POST request at "http://localhost:8080/users/" with JSON Body as:
 { "username": "anand", "password": "pass", "name": "Nikhil", "blog": "This is my new Blog. I am new to this" }
 
 <b>Get all Blog:</b>
 GET request at "http://localhost:8080/users/"
 
 <b>Get particular Blog:</b>
 GET request at "http://localhost:8080/users/<username>"
 
 <b>Update Blog:(Requires both username and password)</b>
 PUT request at "http://localhost:8080/users/{username}/{password}" with JSON Body as:

 {
	"username": "anand",
	"password": "Updatedpass",
	"name": "UpdatedNikhil",
	"blog": "This is my updated Blog. I am old to this"
 }
 
 <b>Delete Blog:(Requires both username and password)</b>
 DELETE request at "http://localhost:8080/users/{username}/{password}"
 
 </br>
 To do:
 1. Add authentication
