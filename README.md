# 🧪 Selenium Java Login Test (TestNG + GitHub Actions)

This is a basic Selenium automation framework using **Java, TestNG**, and **WebDriverManager**, designed to run on **GitHub Actions CI**.

## 📸 Test Scenario

- ✅ Opens Chrome browser
- ✅ Navigates to [the-internet.herokuapp.com/login](https://the-internet.herokuapp.com/login)
- ✅ Enters valid credentials (`tomsmith` / `SuperSecretPassword!`)
- ✅ Verifies successful login message

---

## ⚙️ Tech Stack

| Tool            | Purpose                            |
|-----------------|------------------------------------|
| Java 17         | Programming Language               |
| Selenium 3.141  | UI Automation                      |
| TestNG          | Testing Framework                  |
| WebDriverManager| Manages browser drivers automatically |
| Maven           | Build & Dependency Manager         |
| GitHub Actions  | Continuous Integration             |

---

## 🚀 Run Locally

```bash
git clone https://github.com/mani9247/newseleniumtest.git
cd newseleniumtest
mvn clean test
