# Clack

Team Members: Nathan Collinsworth and Jeffrey Rescignano

## Questions
*Draw a single class diagram connecting all data classes, the ClackClient  class, and the ClackServer class. Feel free to either draw using a program such as Microsoft Visio (or even PowerPoint or Paint if you can manage it), or to use penand-paper and take a photo. Your diagram drawn either digitally or drawn using pen-and-paper and photographed should be copy-pasted into the report.*

![Clack Class Diagram](https://github.com/JeffResc/Clack/blob/master/resources/ClackClassDiagram.png)

*In your test classes, what happens if you provide a negative value for a port number, or a null value for a user? How do you think you can fix these issues?*

In the test classes, if a negative or null value was given for a port number, the ClackClient and ClackServer classes would simply accept the negative or null value. In the future, these issues could be addressed by having a check in the constructor in order to ensure that the given port number is valid (not null or negative). This way, a new ClackClient or ClackServer could not be initialized with an invalid port. Since port is a private variable and cannot be set using a method, a check would only need to be created in the constructor method.

*Explain why you need two new classes for threading*

Two classes are necessary for threading because one class calls the other as a thead. In the ClackServer/ServerSideClientIO implementation, ClackServer represents the server as a whole while ServerSideClientIO represents a thread for each client. ClackServer awaits new clients and as soon as one connects, it starts up a new ServerSideClientIO thread which handles that connection with the client from there after.

*Explain why there should be a separate class to receive data from the server and print it, and the client only gets data from the user and sends it to the server. Also, why is the class called a 'listener'?*

There are two seperate classes because each class is doing it's own seperate thing, but running at the same time. While ClackClient is awaiting the user's keyboard input, ClientSideServerListener is awaiting new incoming messages from the server. This is necessary because the user is now able to send and recieve messages at the same time. The ClientSideServerListener class is called a listener because it is actively 'listening' for new messages from the server.

*Explain why you need a separate thread for each client, and why you cannot handle all clients in the main server thread. Conceptually, why is the listener class 'ClientSideServerListener' different from the class 'ServerSideClientIO'?*

Similarly to the previous question, each client must have it's own thread running on the server because each client is doing a seperate thing. All the threads run simultaneously which allows each client/user to send and recieve messages at the same time, seperate of each other. In order for the server to await messages from each client simultaneously, it must be running on its own thread.

*Explain why the broadcast() and remove() methods are synchronized. You may find it easier to answer this question after completing all programming.*

These two methods are syncronized to prevent two theads from calling them at the same time. This becomes an issue when sharing resources like a variable between multiple threads. If threads A and B call remove() at the exact same time, they will both try to remove themselves from serverSideClientIOList and then write the new list back to serverSideClientIOList. When this happens at the same time, it may happen that one thread will override the other, leaving a faulty value in serverSideClientIOList. Making this method syncronized prevents this from happening and ensures that thread A is done with the resource before thread B attempts to access it.

*Discuss all new methods and new code in existing methods that you wrote to handle LISTUSERS.*

To-do

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