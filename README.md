# Express VPn Ptoject

1. <b> Approach </b>: 
    I have used the BDD approach to write the test-script. Each steps is glue to the respective step-definition file.
    To generate report very impressive report which give you whole understanding of each steps.

2. <b> Test Run Strategy </b>: You can run test based on platform. For that you just need to change the platform variable value from <b>"Config/Common.properties"</b> file
You can run the code using mvn verify and as well as using testNG xml too.

3. <b> Test Assertion Strategy </b>: To do assertion I used testNG assertion methods which verify each and every steps running as expected or not.

4. <b> Localisation Testing </b>: To manage localisation testing create json file in "src/main/resources/Data" directory with the specific set of data need to check. 
Also create same language feature file for the respective feature 

5. To run this code need to just hit the command "mvn test"
