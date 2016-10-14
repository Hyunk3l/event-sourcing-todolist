# event-sourcing-todolist


## How to use


### Create a task

Open terminal and run this command:
```
curl -i -XPOST -H "Content-Type: application/json;charset=UTF-8" -d '{"description": "just another task"}' "http://localhost:8000/tasks"
```

You should get a similar response:
```
HTTP/1.1 200 OK
Date: Fri, 14 Oct 2016 13:19:32 GMT
X-Application-Context: event-sourcing-todolist:8000
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked

{"id":"d1fda785-6320-41c8-9bbd-48ca670e04e8","description":"just another task","createdAt":{"nano":206000000,"epochSecond":1476451172},"modifiedAt":{"nano":206000000,"epochSecond":1476451172}}%
```