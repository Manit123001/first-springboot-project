Reference
https://github.com/in28minutes/SpringBootForBeginners

### Step2
- @Component
- @Autowired
- @RestController
https://github.com/in28minutes/spring-boot-master-class/blob/master/05.Spring-Boot-Advanced/Step02.md

### Step 4
Overrode Version
spring-boot-starter-web-services
spring-boot-starter-test
spring-boot-starter-jdbc
spring-boot-starter-security
spring-boot-starter-data-jpa
spring-boot-starter-data-rest
More at https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#using-boot-starter

### Step 6 
service rest survay http://localhost:8080/surveys/Survey1/questions/

### Step 8
Adding the second method to rest service to retrieve a specific question
https://github.com/in28minutes/SpringBootForBeginners/blob/master/Step08.md

### Step 10
add a new question to survey
https://github.com/in28minutes/SpringBootForBeginners/blob/master/Step10.md



### Output
#### Post
http://localhost:8080/surveys/Survey1/questions/
- request body
```
{
    "id": "Question1",
    "description": "Largest Country in the World",
    "correctAnswer": "Russia",
    "options": [
        "India",
        "Russia",
        "United States",
        "China"
    ]
}
```

#### Get 1
http://localhost:8080/surveys/Survey1/questions/
```[
    {
        "id": "Question1",
        "description": "Largest Country in the World",
        "correctAnswer": "Russia",
        "options": [
            "India",
            "Russia",
            "United States",
            "China"
        ]
    },
    {
        "id": "Question2",
        "description": "Most Populus Country in the World",
        "correctAnswer": "China",
        "options": [
            "India",
            "Russia",
            "United States",
            "China"
        ]
    },
    {
        "id": "Question3",
        "description": "Highest GDP in the World",
        "correctAnswer": "United States",
        "options": [
            "India",
            "Russia",
            "United States",
            "China"
        ]
    },
    {
        "id": "Question4",
        "description": "Second largest english speaking country",
        "correctAnswer": "India",
        "options": [
            "India",
            "Russia",
            "United States",
            "China"
        ]
    }
]
```
#### Get 2
http://localhost:8080/surveys/Survey1/questions/Question1
```{
    "id": "Question1",
    "description": "Largest Country in the World",
    "correctAnswer": "Russia",
    "options": [
        "India",
        "Russia",
        "United States",
        "China"
    ]
}
```

###  Step 14 
https://github.com/in28minutes/SpringBootForBeginners/blob/master/Step14.md
set up other of service embeded like a jetty, tomcat

###  Step 15
https://github.com/in28minutes/SpringBootForBeginners/blob/master/Step15.md
`YAML @Value(${key})` Parameter global
- Using Dynamic Configuration in your application
- Customize Welcome Message
- Different ways of configuration
- --welcome.message="SomethingElse" in Program Arguments"
- --spring.config.location=classpath:/default.properties
- We will learn about profiles in next step
- Using Placeholders
- YAML 

### Step 16
https://github.com/in28minutes/SpringBootForBeginners/blob/master/Step16.md
`@Bean, @Profile("dev"), ` Flavors run
- Understand Basics of Profiles
- Setting a profile
- Using -Dspring.profiles.active=prod in `VM Arguments`
- spring.profiles.active=prod
- Using a profile
- application-{profile-name}.properties
- @Profile("dev") on a bean
- Usage
- Configure Resources - Databases, Queues, External Services

### Step 17
https://github.com/in28minutes/SpringBootForBeginners/blob/master/Step17.md
`@ConfigurationProperties("basic")`
- better configuration management than @Value
- Type-safe Configuration Properties

### Step 18
https://github.com/in28minutes/SpringBootForBeginners/blob/master/Step16.md
Create a very simple example with Spring Data JPA

JPA : Java Persistent Api = use for map java object to any DB relations 
- Let's switch back to tomcat first!
- Get introduced to Spring Data JPA
- Create a very simple example with Spring Data JPA
- Use CommandLineRunner!

Useful Properties
- spring.datasource.driver-class-name=com.mysql.jdbc.Driver
- spring.datasource.url=jdbc:mysql://localhost:3306/test
- spring.datasource.username=root
- spring.datasource.password=admin
- spring.datasource.initialize=true
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true

### Step 19
https://github.com/in28minutes/SpringBootForBeginners/blob/master/Step19.md

Spring data jpa document 
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details

- Look at H2 Console : http://localhost:8080/h2-console
    - Use db url jdbc:h2:mem:testdb
- Add findByRole method

### Step 20
https://github.com/in28minutes/SpringBootForBeginners/blob/master/05.Spring-Boot-Advanced/Step20.md

- Learn Spring data rest that use to build a simple REST API.
- Introduction to Spring Data Rest
- Hit http://localhost:8080/users in POSTMAN
- http://localhost:8080/users/1
- http://localhost:8080/users/?size=4
- http://localhost:8080/users/?sort=name,desc
- @Param("role")
- http://localhost:8080/users/search/findByRole?role=Admin
- Good for quick prototype! Be cautious about using this in Big applications!

### Step 21
https://github.com/in28minutes/SpringBootForBeginners/blob/master/05.Spring-Boot-Advanced/Step21.md

SurveyController TDD `SurveyControllerIT.clss -> testRetrieveSurveyQuestion`

### Step 22
https://github.com/in28minutes/SpringBootForBeginners/blob/master/05.Spring-Boot-Advanced/Step22.md

SurveyController TDD `SurveyControllerIT.clss -> addQuestion.clss`

### Step 23
https://github.com/in28minutes/SpringBootForBeginners/blob/master/05.Spring-Boot-Advanced/Step23.md

- Clean code 
- SurveyController TDD `SurveyControllerIT.clss -> retrieveAllSurveyQuestions.clss`

### Step 24
https://github.com/in28minutes/SpringBootForBeginners/blob/master/05.Spring-Boot-Advanced/Step24.md

Unit Test -> `SurveyControllerTest.clss -> retrieveDetailsForQuestion.clss`

- Write a Unit Test for retrieving a specific question from a survey.
- Different between Unit Test and Integration Test
- Basics of Mocking
- MockMvc framework
- @MockBean
- Programming Tip
- Be an expert at Mockito - https://courses.in28minutes.com/p/mockito-for-beginner-in-5-steps