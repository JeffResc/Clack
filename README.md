# Clack

Team Members: Nathan Collinsworth and Jeffrey Rescignano

## Questions
*Draw a single class diagram connecting all data classes, the ClackClient  class, and the ClackServer class. Feel free to either draw using a program such as Microsoft Visio (or even PowerPoint or Paint if you can manage it), or to use penand-paper and take a photo. Your diagram drawn either digitally or drawn using pen-and-paper and photographed should be copy-pasted into the report.*

![Clack Class Diagram](https://github.com/JeffResc/Clack/blob/master/resources/ClackClassDiagram.png)

*In your test classes, what happens if you provide a negative value for a port number, or a null value for a user? How do you think you can fix these issues?*

In the test classes, if a negative or null value was given for a port number, the ClackClient and ClackServer classes would simply accept the negative or null value. In the future, these issues could be addressed by having a check in the constructor in order to ensure that the given port number is valid (not null or negative). This way, a new ClackClient or ClackServer could not be initialized with an invalid port. Since port is a private variable and cannot be set using a method, a check would only need to be created in the constructor method.

## Example Output
ClackServer:
```
PS > java -jar ClackServer.jar
MessageClackData [message=Hello, userName=Anon, type=2]
MessageClackData [message=TESTING, userName=Anon, type=2]
FileClackData [fileName=README.md, fileContents=# ClackTeam Members: Nathan Collinsworth and Jeffrey Rescignano## Questions*Draw a single class diagram connecting all data classes, the ClackClient  class, and the ClackServer class. Feel free to either draw using a program such as Microsoft Visio (or even PowerPoint or Paint if you can manage it), or to use penand-paper and take a photo. Your diagram drawn either digitally or drawn using pen-and-paper and photographed should be copy-pasted into the report.*![Clack Class Diagram](https://github.com/JeffResc/Clack/blob/master/resources/ClackClassDiagram.png)*In your test classes, what happens if you provide a negative value for a port number, or 
a null value for a user? How do you think you can fix these issues?*In the test classes, if a negative or null value 
was given for a port number, the ClackClient and ClackServer classes would simply accept the negative or null value. 
In the future, these issues could be addressed by having a check in the constructor in order to ensure that the given port number is valid (not null or negative). This way, a new ClackClient or ClackServer could not be initialized with an invalid port. Since port is a private variable and cannot be set using a method, a check would only need to be created in the constructor method., userName=Anon, type=3]
MessageClackData [message=DONE, userName=Anon, type=2]
```

ClackClient:
```
PS > java -jar ClackClient.jar
Hello
Anon
2    
Hello
TESTING
Anon   
2      
TESTING
SENDFILE README.md
Anon
3
# ClackTeam Members: Nathan Collinsworth and Jeffrey Rescignano## Questions*Draw a single class diagram connecting all data classes, the ClackClient  class, and the ClackServer class. Feel free to either draw using a program such as Microsoft Visio (or even PowerPoint or Paint if you can manage it), or to use penand-paper and take a photo. Your diagram drawn either digitally or drawn using pen-and-paper and photographed should be copy-pasted into the report.*![Clack Class Diagram](https://github.com/JeffResc/Clack/blob/master/resources/ClackClassDiagram.png)*In your test classes, what happens if you provide a negative value for a port number, or a null value for a user? How do you think you can fix these issues?*In the test classes, if a negative or null value was given for a port number, the ClackClient and ClackServer classes would simply accept the negative or null value. In the future, these issues could be addressed by having a check in the constructor in order to ensure that the given port number is valid (not null or negative). This way, a new ClackClient or ClackServer could not be initialized with an invalid port. Since port is a private variable and cannot be set using a method, a check would only need to be created in the constructor method.
DONE
Anon
2
DONE
```