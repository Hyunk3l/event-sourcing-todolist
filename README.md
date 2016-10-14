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

### Get tasks list

After inserting one or more tasks, get a list of them:
```
curl -i -XGET -H "Content-Type: application/json;charset=UTF-8" "http://localhost:8000/tasks"
```

you should get something similar to:
```
HTTP/1.1 200 OK
Date: Fri, 14 Oct 2016 13:56:43 GMT
X-Application-Context: event-sourcing-todolist:8000
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked

[{"id":"85e095dc-9140-4646-bc89-a1566ce02696","description":"just another task","createdAt":{"nano":28000000,"epochSecond":1476453171},"modifiedAt":{"nano":28000000,"epochSecond":1476453171}},{"id":"0d9c3cca-da0e-4823-b070-08f623a4b041","description":"just another task","createdAt":{"nano":639000000,"epochSecond":1476453179},"modifiedAt":{"nano":639000000,"epochSecond":1476453179}},{"id":"faea0c93-70de-488d-9dca-0c976a61073a","description":"just another task","createdAt":{"nano":249000000,"epochSecond":1476453180},"modifiedAt":{"nano":249000000,"epochSecond":1476453180}},{"id":"8c673e33-c099-4ad2-adf9-b8d8f9278436","description":"just another task","createdAt":{"nano":937000000,"epochSecond":1476453180},"modifiedAt":{"nano":937000000,"epochSecond":1476453180}}]
```