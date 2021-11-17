## Video Tutorial on Youtube:

[Video tutorial link](https://www.youtube.com/watch?v=z3Zty_aX7ZI&list=PL8VbCbavWfeE5aEeEpoXp2xiHi5K_7BMT)

Checked videos: 

21`Need to start`

## To install a new json server:

### Things to take in mind
1. Check if you have node installed on your machine ``$ node --version``

2. Install json server globally ``$ npm install -g json-server``
-- For more information about jsonServer [here](https://www.npmjs.com/package/json-server)

3. You can create a new module (optional)
   
   3.1. If you created a new module you need to go to this path

### In a new terminal: 
```shell
$ ls 
$ cd JSON_SERVER
$ json-server --watch db.json
```
4. Now if you go to [http://localhost:3000/posts/1](http://localhost:3000/posts/1), you'll get
+ Check respose on the browser. You need to se something like this:

```json5
{ "id": 1, "title": "json-server", "author": "typicode" }
```

### To start Json server just copy this command line on the terminal 
```shell
$ json-server --watch db.json
```

### It you can try to test a API service without any server you can check it with this fake API 

```text
https://jsonplaceholder.typicode.com/
```

### POSTMAN:

I have a collection on postman for this video course: 
```text
restAssureTutorial
``` 
### Using Hamcrest for testing - Tutorial

Link: [Hamcrest](https://www.vogella.com/tutorials/Hamcrest/article.html)

Tutorial [Link](http://hamcrest.org/JavaHamcrest/tutorial)

### JSONPath Online Evaluator

Link: [JSONPath Online Evaluator](http://jsonpath.com/)

## JSON to Pojo --> buy You can use lombok for this feature
Just add response with json formant to setup the JsonPojo file

You can check it in this [Link](https://www.jsonschema2pojo.org/)