HEY TEAM CAPSTONE WHATSUP GUYS

So here's a list of things you're going to need in order to be able to run this project in your local machine:


Eclipse (pref, i mean you can use netbeans but why would you)
I'm not going to leave an explanation - this guy is pretty easy to dl + install


Eclipse Terminal
This is a nice little tool that adds a built-in terminal within your eclipse IDE, kinda like the one that VS Code offers. This isn't 100% necessary, but will make your life easier. To download:
1. In Eclipse, go to 'Help' in the menu up top, then to Eclipse Marketplace and type 'Terminal' in the find bar.
2. Install TM Terminal
3. Restart Eclipse
4. Window -> Show View -> Terminal (or ctrl + alt + T for hotkey users)



Maven
This is a maven project - maven is just like Gradle (which we used in Android dev) and NPM - it's a package manager that basically takes build and run commands from your application and executes them when you provide a lifecycle hook. This means that it's extremely necessary because it's the application that handles the running of the Scheduler. Unfortunately, that also means installing this can be a bit of a headache:

1. Ensure you have Java installed on your PC:
1.a : if you do, then go to your PC's Environment Variables and include one with the following parameters:
	-> Variable NAme: JAVA_HOME
	-> Variable Value: (mine was C:\Program Files\Java\jdk13.2.0 or smth)
		-> NOTE: usually, we direct these straight to the \bin file, 
                      but don't do that for this one or it'll mess you up.
1.b : If you don't, then grab it (https://www.oracle.com/technetwork/java/javase/downloads/index.html) and then do 1.a
2. Install Maven from here https://maven.apache.org/download.cgi
3. Create two new User Variables:
	-> Variable Name: M2_Maven
	-> Variable Name: MAVEN_HOME
		-> Both should point to your maven directory.
4. Add Maven's \bin to your PATH in your environment variables
5. Open up cmd.exe (or hyper or w/e for Esther) and type mvn -version to ensure it's working properly.

If I didn't make sense (This took me a while to get working), try following this tutorial: 
https://howtodoinjava.com/maven/how-to-install-maven-on-windows/


To run using the 'play' button within the IDE:
Go to Run>Run Configurations
From the side panel, select Java Application>SchedulerApplication
In the main class, enter 'com.capstone.Scheduler.SchedulerApplication'
This is the package for our main function, so we need to ensure it's there or the running will fail.






To re-run the program (i.e. rebuild and recompile - generally, Spring will update changes to the program ad hoc, so you won't have to do this every time, but if you've made big changes and you aren't sure they're loading, it's a good idea to try this), we need to kill Spring's Tomcat instance. We can do that with the following bash commands:

in cmd.exe:
>netstat -ano | findstr 8080
This line will run the netstat command, which returns information on your ports and the processes which are running on them. The -ano | findstr 8080 means we're telling cmd we're only looking for entries with '8080' in it (that's our port number for Tomcat). This will return lines like the following:

C:\Users\adamp>netstat -ano | findstr 8080
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       9664
  TCP    [::]:8080              [::]:0                 LISTENING       9664

In the above entries, we see 'LISTENING		9664' at the end of both of them. What that means is that a process with process id 9664 is running on these ports. With that information, we'll need to run the following command:

>taskkill /pid 9664 /f
Where the 9664 will be whatever process your netstat command turned up.



Thanks, and have a good week all~!