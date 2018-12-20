# FacebookTestProject

This project contains one test, which can be run:
1) in your local Web browser Chrome of the latest version;
2) on mobile devices (in Chrome on Android platform and in Safari on device with iOS).

**Before testing make sure that you have already set JAVA_HOME, M2_HOME, ANDROID_HOME environment variables.**

## Web testing in Chrome browser 

To run test in terminal:
1. Download the project
2. Set facebook credentials in /src/main/resources/config.properties file
3. Open terminal and go to the project root directory
4. Run command 

`mvn clean -Dsuite=config.xml -Dwebdriver.browser=CHROME  test`


## Mobile testing
Preconditions: 
1. Install and run Appium server with such parameters: 

  - address: 127.0.0.1, port: 4723

  - chromedriverExecutable: {path-to-chromedriver} - for android testing only!

2. Download the project
3. Set facebook credentials in /src/main/resources/config.properties file


###### Android testing:
4. Create and run emulator with the name "emulator-5554"
5. Open terminal and go to the project directory
6. Run command 

`mvn clean -Dsuite=config.xml -Dwebdriver.browser=ANDROID  test`

###### iOS testing:
4. Set required capabilities in /src/main/resources/config.properties (such as "deviceName" and "udid")
5. Run simulator
6. Open terminal and go to the project directory
7. Run command 

`mvn clean -Dsuite=config.xml -Dwebdriver.browser=iOS  test`


## Reports
Report is stored in target/surefire-reports/index.html 
