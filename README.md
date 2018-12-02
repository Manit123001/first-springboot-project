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
