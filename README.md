# 📊 SeleniumPomDataDriven

This project implements **data-driven test automation** for unit conversions using [https://www.digitaldutch.com/unitconverter/](https://www.digitaldutch.com/unitconverter/) as the system under test. The project uses **Selenium WebDriver** in Java with the **Page Object Model (POM)** architecture and integrates **TestNG** and **Excel-based Data Providers** to cover dynamic testing scenarios across various measurement units.

> ✅ Live base URL: [https://www.digitaldutch.com/unitconverter/length.htm](https://www.digitaldutch.com/unitconverter/length.htm)  
> 📦 GitHub Repo: [https://github.com/otakmager/SeleniumPomDataDriven](https://github.com/otakmager/SeleniumPomDataDriven)

---

## 🧱 Project Structure

```
SeleniumPomDataDriven/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/              # BaseTest & core setup
│   │       ├── pageObjects/       # Page Objects
│   │       ├── pageEvents/        # Page Events (logic layer)
│   │       ├── keyword       	   # Action & validation Keywords
│   │       └── utils/             # ExcelUtils, ReportManager, Constants
│   ├── test/
│   │   └── java/
│   │       └── testCases/
│   │           ├── LengthConverterTest.java
│   │           ├── MassConverterTest.java
│   │           ├── TimeConverterTest.java
│   │           └── UserInterfaceTest.java
│   └── resources/
│       └── datasets.xlsx          # Test data for each converter sheet
├── logs/                          
│   └── app.log                    # Test log
├── reports/                       # HTML reports generated via ExtentReports
├── screenshots/                   # Failure screenshots (auto-captured)
├── testng.xml                     # Master suite file
└── README.md
```

---

## ✅ Features

- 💡 **POM (Page Object Model)** based design for maintainability and reuse
- 🧪 **Data-Driven Testing** using `.xlsx` files via Apache POI
- 🧾 **HTML Reports** using ExtentReports
- 📸 **Screenshot on Failure**
- ⚙️ **Logger Integration** with `log4j2` for test activity traceability

---

## 🚀 How to Run

### 1. Clone the Repository
```bash
git clone https://github.com/otakmager/SeleniumPomDataDriven.git
```

### 2. Open in IntelliJ IDEA
- Requires: **IntelliJ IDEA Community Edition 2024.3.5**
- Uses: **Java JDK 17**
- Built-in: **TestNG plugin** (no external Maven setup required)

### 3. Run All Tests
- Right-click `testng.xml` → **Run 'testng.xml'**
- HTML report will be created in the `/reports/` folder

---

## 📦 Test Coverage

Each test class corresponds to a category of unit conversion or interaction:

| Test Class                | Description                      | Sheet in Excel       |
|---------------------------|----------------------------------|----------------------|
| [`LengthConverterTest`](https://github.com/otakmager/SeleniumPomDataDriven/blob/main/src/test/java/testCases/length/LengthConverterTest.java)     | Convert between length units     | `length`             |
| [`MassConverterTest`](https://github.com/otakmager/SeleniumPomDataDriven/blob/main/src/test/java/testCases/mass/MassConverterTest.java)       | Convert between mass units       | `mass`               |
| [`TimeConverterTest`](https://github.com/otakmager/SeleniumPomDataDriven/blob/main/src/test/java/testCases/time/TimeConverterTest.java)       | Convert between time units       | `time`               |
| [`UserInterfaceTest`](https://github.com/otakmager/SeleniumPomDataDriven/blob/main/src/test/java/testCases/ui/UserInterfaceTest.java)       | Basic smoke tests for UI access  | *(no data source)*   |

---

## 📊 Test Data Source

All test inputs are stored in [`src/test/resources/datasets.xlsx`](https://github.com/otakmager/SeleniumPomDataDriven/raw/refs/heads/main/src/test/resources/datasets.xlsx) with dedicated sheets per category.

Each sheet has the format:
```
Value1    |   fromUnit         |   Value2    |   toUnit
------------------------------------------------------------
12.5      | kilometers [km]    | 12500       | meters [m]
...
```

The `ExcelUtils` dynamically reads rows and feeds them into tests via `@DataProvider`.

---

## 📜 Logs & Reports

- ✅ Logs written to: [`logs/app.log`](https://github.com/otakmager/SeleniumPomDataDriven/blob/main/logs/app.log)
- ✅ HTML test report: [`reports/test-report.html`](https://github.com/otakmager/SeleniumPomDataDriven/blob/main/reports/test-report.html)
- ✅ Screenshots on failure: [`screenshots/`](https://github.com/otakmager/SeleniumPomDataDriven/tree/main/screenshots)

Log includes detailed info such as:
- Test start markers per method
- Excel data loading feedback
- Element interaction and assertion steps

---

## 🔧 Technologies Used

- Java 17
- Selenium WebDriver
- TestNG
- Apache POI (Excel reading)
- ExtentReports
- log4j2
- WebDriverManager
- IntelliJ IDEA CE 2024.3.5

---
