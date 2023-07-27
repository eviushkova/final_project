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

<p align="left">
<a href="https://rest-assured.io/"><img src="images/logo/RestAssured.svg" width="50" height="50"  alt="RestAssured" title="RestAssured"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure_Report.svg" width="50" height="50" alt="Allure" title="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://web.telegram.org/"><img src="images/logo/Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"></a>
<a href="https://qameta.io/"><img src="images/logo/AllureTestOps.svg" width="50" height="50" alt="AllureTestOps" title="AllureTestOps"></a>
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
