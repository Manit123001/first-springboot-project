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

Step 6 
service rest survay http://localhost:8080/surveys/Survey1/questions/

Step 8
Adding the second method to rest service to retrieve a specific question
https://github.com/in28minutes/SpringBootForBeginners/blob/master/Step08.md

Step 10
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
}```
