# Automated tests for [stepik.org](https://stepik.org/)

> Stepik is a platform with the best online courses devoted to Computer Science and everything tech-related. Learn data structures, Python programming, statistics and many other useful skills. Access video lectures and assignments on the go.

<img title="Jenkins Build" src="images/screens/MainPage.png">

## :pushpin: Content:

- [Stack of technologies](#computer-stack-of-technologies)
- [Running tests](#running_woman-running-tests)
- [Build in Jenkins](#-build-in-jenkins)
- [Allure report](#-allure-report)
- [Allure TestOps Integration](#-allure-testops-integration)
- [Telegram notifications](#-telegram-notifications)


## :computer: Stack of technologies

<p align="center">
<img width="6%" title="Java" src="images/logo/Java.svg">
<a href="https://rest-assured.io/"><img src="images/logo/RestAssured.svg" width="50" height="50"  alt="RestAssured" title="RestAssured"/></a>
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Allure TestOps" src="images/logo/AllureTestOps.svg">
</p>

## :rocket: Running tests

If necessary, you can override the launch options:

```
clean
build
-DbaseUrl=${BASE_URL}
-Demail=${EMAIL}
-Dpassword=${PASSWORD}
```

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Build in [Jenkins](https://jenkins.autotests.cloud/job/final_project_eviush/)
<p align="center">
<img title="Jenkins Build" src="images/screens/JenkinsBuild.png">

</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> [Allure](https://jenkins.autotests.cloud/job/final_project_eviush/14/allure/) report
### Overview

<p align="center">
<img title="Allure Overview" src="images/screens/AllureReport.png">
</p>

### Test result

<p align="center">
<img title="Test Results in Allure" src="images/screens/TestResults.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps Report" src="images/logo/AllureTestOps.svg"> [Allure TestOps](https://allure.autotests.cloud/launch/25480) Integration

Also we can connect <code>Jenkins</code> to the commercial version of <code>Allure</code>, which provides an opportunity to add there manual tests as well as an automated ones:

<p align="center">
<img title="Test Results in Allure" src="images/screens/AllureTestOps.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Telegram notifications

<p align="center">
<img width="50%" title="Telegram Notifications" src="images/screens/Telegram.png">
</p>