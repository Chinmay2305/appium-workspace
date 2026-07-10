# Android Automation Proof of Concept (PoC)

## Overview
This project is a Proof of Concept (PoC) for Android Mobile Automation using Appium, Java, TestNG and Maven.
The project demonstrates the automation of the Login screen of the Shree Patan Jain Mandal Android application using the Page Object Model (POM) design pattern.

## Technology Stack
- Java 25
- Appium 3.5.2
- Appium Java Client
- TestNG
- Maven
- Extent Reports
- Android Emulator
- UIAutomator2

## Framework Design
src
 ├── test
 │    ├── java
 │    │      ├── pages
 │    │      │      LoginPage.java
 │    │      │
 │    │      ├── tests
 │    │      │      LoginTest.java
 │    │      │
 │    │      ├── shreepatan
 │    │      │      BaseTest.java
 │    │      │
 │    │      └── utils
 │    │      │       ReportManager.java
 │    │      │
 │    │      ├── resources
 │    │      │      app.patan.jainmandal.shree_patan_jain_mandal.apk
 │    │      │      config.arm64_v8a.apk
 │    │      │      config.en.apk
 │    │      │      config.mdpi.apk
 │    │      │      config.zh.apk
 │    │      │      icon.png
 │    │      │      manifest.json
 pom.xml
 ReadMe.md
```

---

## Features Implemented
- Automatic Appium Server startup
- Automatic Appium Server shutdown
- Automatic Application Launch
- Automatic Permission Handling
- Explicit Waits
- Page Object Model (POM)
- Extent Report Generation
- Toast Message Validation

---

## Automated Test Scenarios

### Login Screen UI
- Verify Welcome title
- Verify subtitle
- Verify login heading
- Verify Login button is displayed
- Verify Login button is enabled

---

### Functional Validation
- Empty Mobile Number
- Unregistered Mobile Number
- Invalid Mobile Number Format
- Alphabet Input Validation
- Special Character Validation
- Space Validation
- Less than 10 Digits Validation
- More than 10 Digits Validation

---

## Reports
Execution report is generated automatically using Extent Reports.

Location:

```
test-output/ExtentReport.html
```

---

## How to Run

### Prerequisites

- Java JDK 8
- Maven
- Node.js
- Appium Server
- Android SDK
- Android Emulator or Real Device
- **P.S. Note**: This is a split apk (not a debug or universal one) so, follow these steps for installation:
	1. Launch the desired emulator in android studio
		2. Change the name of emulator in the eclipse code
		3. In CMD from app location [here: \ShreePatan\src\test\java\resources], install using ADB: adb install-multiple base.apk config.en.apk config.mdpi.apk config.arm64_v8a.apk
		4. Now Appium code will work

---

### Execute Tests

```
mvn test
```

or execute the TestNG suite from Eclipse.

---

## Project Highlights

- Clean Page Object Model
- Reusable methods
- Maintainable code
- TestNG Assertions
- Mobile UI Validation
- Toast Message Verification

---

## Author
**Chinmay Agrawal**
Senior QA Automation Engineer