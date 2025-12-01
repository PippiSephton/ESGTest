# Getting Started

### Reference Documentation
To run the Application all you have to do is navigate to the 'src/main/java/com/esg/test/ESGTest/EsgTestApplication.java' file and click on run.

The application uses a H2 database for the backend so that when the application is ran, the DB will be populated with the custom table that I have defined called Customer.

When the Post operation is called on the api 'http://localhost:3001/api/customer', with a valid body of either testcsv1.csv or testcsv2.csv, the database will be populated with the data and all the data from that file will be returned in JSON format. If a response is not any of the defined csv files an internal server error of 500 will be thrown.

When the Get operation is called on 'http://localhost:3001/api/customer/{refId}' the customer data will be returned on the reference ID if the refId is present in the DB otherwise a 404 not found error will occur.



I used the H2 database because it is quick and easy to run requiring no additional programs to be ran at the same time and the data did not need to be persisted through the destruction and reconstruction of the App.

I Used OpenCsv as an alternative to BufferedStringReader as I thought that support for commas in quotes might be useful if a user inputs their address in the incorrect fields. Either could of been used with correct validation of the data beforehand.