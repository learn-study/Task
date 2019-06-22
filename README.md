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


get + index.html

get + NewTask

post + NewTask

get + taskedit

post + taskedit

get + taskshow 

get + taskdelete
