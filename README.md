# 🧮 PrimeChecker API (Spring Boot + Gradle)

A simple Spring Boot API to check whether a given number is a prime. 

## ✅ Prerequisites

Before running this project locally, make sure you have the following:

- **Java JDK 21** installed. Check with:  
  ```bash
  java -version

- **Gradle Wrapper** is included (`./gradlew` and `gradlew.bat`).
  No need to install Gradle separately.

- **Git** (only if you're cloning the repository). Check with:

  ```bash
  git --version
  ```

## 🚀 How to Run the Project Locally

### 1. Clone the Repository (if not already)

```bash
git clone https://github.com/Muskan244/PrimeChecker.git
cd PrimeChecker
```

### 2. Build the Project

```bash
./gradlew build
```

> On Windows:
>
> ```cmd
> gradlew.bat build
> ```

### 3. Run the Application

#### Option A: Using Gradle BootRun

```bash
./gradlew bootRun
```

#### Option B: Run the JAR File

After building the project, run:

```bash
java -jar build/libs/PrimeChecker-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`.

## 🔎 Test the API Endpoint

The API provides one GET endpoint:

```
GET /isPrime?number={number}
```

### Example Requests

* ✅ Prime Number:

  ```
  http://localhost:8080/isPrime?number=17
  ```

  **Response:**

  ```json
  {
    "number": 17,
    "isPrime": true
  }
  ```

* ❌ Non-Prime:

  ```
  http://localhost:8080/isPrime?number=18
  ```

  **Response:**

  ```json
  {
    "number": 18,
    "isPrime": false
  }
  ```

* ❗ Missing or Invalid Parameter:

  ```
  http://localhost:8080/isPrime
  ```

  **Response (400):**

  ```json
  {
    "error": "Missing required query parameter 'number'."
  }
  ```
  
## 🛑 Stop the Application

Press `Ctrl + C` in the terminal where it's running.
