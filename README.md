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

*** 

* get + NewTask

form for new Task

forword views/task/new.jsp

*** 

* post + NewTask

create new Task

rediretct_to index.html

***

* get + taskedit

form for edit Task

forword views/task/edit.jsp

***

* post + taskedit

update Task

redirect_to index.html

***

* get + taskshow 

TaskPage

forword views/task/show.jsp

***

* get + taskdelete

delete Task

redirect_to index.hmtl
