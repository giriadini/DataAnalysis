# DataAnalysis

Create Database creation, 
I have used Mongodb and created the database and collections .
Generate 10 GB of data.

I have used Jmeter to load high load data , I have configured Jmeter with REST webservices , such it calls the application and stores the data in the configured database.

For reference,I have attached the Jmeter configuration file to contact with the built Rest Application.

Url to run :

http://localhost:8080/RestDataAnalysis/api/webservice/insert/sid4/act_2/rawdata/success

http://localhost:8080/RestDataAnalysis/api/webservice/insert/sid4/act_2/data

4. I have created map reduce program called DataAnalysis.jar
Suggestion: we can achieve this program inside mongodb , MongoDb provides a facility to run map reduce program on the data.

5. Create a tool or use any existing to export data from the database into a CSV file
I have used  Mongodb in this application, Data can be exported to csv file using the below command.


Mongoexport –d Myoutput –c Traces –o out.csv


 I have created a sample junit class in the RestDataAnalysis project.





