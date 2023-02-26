# Ecompass-Api
* This project store the data of user ecompass website system 
## Framwork and Language use in this Project
* Springboot 
* java
## Dependencies
* Spring Web
* mysql Database
* hibernate
* lombok
* jpa
* spring dev tools 
## Flow of project
* Create three layers model , service , controller, repository.
* In model layer create four classes first one is student class second laptop class third courses class fourth one is books class fith one is address class.
* In controller layer to performe CRUD operatiom by http request.
* In service layer write a business logic of CRUD operation.
* In repository layer exteds jpsRepositor.
## Constraints:
* student model will have-
* Id
* name
* department
* age
* branch
* phoneNumber
* embaded address class
* laptop model will have:-
* id
* name 
* price
* brand 
* one to one relation with student
* books model will have:-
* id
* author 
* description
* price
* mant to one relation with student
* course model will have-
* Id
* title
* duration
* description
* many to many relation of student list 
* address model will have-
* addressId
* addressname
* landmark
* phoneNo
* zipcode
* state
## Endpoints to provided :
* get student by id
* get all student
* delete student by id
* update tudent by id
* post student
* same crude operation performe the endpoints of course controller, laptop controller, books controller.
