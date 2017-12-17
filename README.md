# AzureHOLsAutomation
Automation steps for Azure Hands-on-labs using Selenium WebDriver
The code is run based on Mac version chrome driver. Running on other system could be possible but have not been tried.

## Get Started
Put your account email and password at  
```
$ src/main/java/com/cs527project/holstest/htmlelements/utils/enumerations/AccountInfo.java
```
Default webDriver is Mac version, if run on other systems, use corresponding version driver and put it at
```
$ src/resources/drivers/YourDriverFileName
```
And reset the driver path at following file by replacing "chromeDriver" of chromeDriverPath variable at line 20 with your driverFileName
```
$ src/main/java/com/cs527project/holstest/htmlelements/utils/Driver/BrowserDriver.java
```
Make sure resources are all deleted before running. If one automation step is run successfully, to run the same one or others, wait until the resource is deleted. You can either check through portal or wait for usually 5 mins (10 min for container auotmation).
Running all steps is not supported and expected to fail. Because the automation steps will trigger deleting resource but will not wait until deletion finished which may cause remaining resources.
Command for running each individual automation step 
```
$ mvn test -Dtest=TestGettingStartedWithAzure
$ mvn test -Dtest=TestAzureWebApps
$ mvn test -Dtest=TestDockerContainersInTheAzureContainerService
$ mvn test -Dtest=TestAzureStorageAndCognitiveServices
```
