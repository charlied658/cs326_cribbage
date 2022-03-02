To set up the DB driver on a Linux Lab Machine:
1. Start BasicQuery from the 
   Application | Web Development |BasicQuery menu

2. Exit BasicQuery 
   (started only to assure the initial properties file was setup)

3. Edit ~/BasicQuery/BasicQuery.Properties

   Update the DBDRIVERDIR entry to be:
      DBDRIVERDIR=/students/home/YOURID/BasicQuery/DBDrivers
   where YOURID is your system login name

4. Close the editor

5. Edit ~/BasicQuery/BasicQuery.Drivers

   Update the MySQL line to be:
		com.mysql.jdbc.Driver,MySQL

6. Close the editor


7. Create the directory ~/BasicQuery/DBDRIVERS

8. Copy the mysql-connector-java-8.0.27.jar into ~/BasicQuery/DBDRIVERS

9. If there is a temporary pinhole needed, remember to open the pinhole

10. Run BasicQuery and test DB connectivity

