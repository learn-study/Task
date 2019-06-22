# TaskManager

## FillterEncoding

write `public void doFilter` following

`EncodingFilter.java`

```
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
```

global path for @WebFilter annotation

``` 
@WebFilter("/*")
``` 

*** 

## routing

* get + index.html

Task indexes

* get + NewTask

form for new Task

* post + NewTask

create new Task

* get + taskedit

form for edit Task

* post + taskedit

update Task

* get + taskshow 

TaskPage

* get + taskdelete

delete Task
