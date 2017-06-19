#####################################

 hello-world-spring-mvc-web-app
#####################################

This is a simple 'hello-world' web application that leverages Spring MVC, Spring boot, Thymeleaf as view technology and Apache Maven.

Source: https://spring.io/guides/gs/serving-web-content/#initial

################################

Key notes about the application
################################

The Spring Boot Maven plugin s been used (as can be seen in pom.xml); it provides many convenient features:

> It collects all the jars on the classpath and builds a single, runnable "über-jar", which makes it more convenient to execute and transport your service.
> It searches for the public static void main() method to flag as a runnable class.
> It provides a built-in dependency resolver that sets the version number to match Spring Boot dependencies. You can override any version you wish, but it will default to Boot’s chosen set of versions.

Developing web apps:

A common feature of developing web apps is coding a change, restarting your app, and refreshing the browser to view the change. This entire process can eat up a lot of time. To speed up the cycle of things, Spring Boot comes with a handy module known as spring-boot-devtools:

> Enable hot swapping
> Switches template engines to disable caching
> Enables LiveReload to refresh browser automatically
> Other reasonable defaults based on development instead of production

Making the application executable:

Although it is possible to package this service as a traditional WAR file for deployment to an external application server, the simpler approach demonstrated below creates a standalone application. You package everything in a single, executable JAR file, driven by a good old Java main() method. Along the way, you use Spring’s support for embedding the Tomcat servlet container as the HTTP runtime, instead of deploying to an external instance.

@SpringBootApplication is a convenience annotation that adds all of the following:

> @Configuration tags the class as a source of bean definitions for the application context.
> @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
> Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
> @ComponentScan tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.

The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. Did you notice that there wasn’t a single line of XML? No web.xml file either. This web application is 100% pure Java and you didn’t have to deal with configuring any plumbing or infrastructure.

Build an executable JAR:

You can run the application from the command line with Gradle or Maven. Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources, and run that. This makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.

If you are using Gradle, you can run the application using ./gradlew bootRun. Or you can build the JAR file using ./gradlew build. Then you can run the JAR file:

java -jar build/libs/gs-serving-web-content-0.1.0.jar
If you are using Maven, you can run the application using ./mvnw spring-boot:run. Or you can build the JAR file with ./mvnw clean package. Then you can run the JAR file:

java -jar target/gs-serving-web-content-0.1.0.jar


Test the App:

Now that the web site is running, visit http://localhost:8080/greeting, where you see:

"Hello, World!"
Provide a name query string parameter with http://localhost:8080/greeting?name=User. Notice how the message changes from "Hello, World!" to "Hello, User!":

"Hello, User!"
This change demonstrates that the @RequestParam arrangement in GreetingController is working as expected. The name parameter has been given a default value of "World", but can always be explicitly overridden through the query string.

Add a Home Page:

Static resources, like HTML or JavaScript or CSS, can easily be served from your Spring Boot application just be dropping them into the right place in the source code. By default Spring Boot serves static content from resources in the classpath at "/static" (or "/public"). The index.html resource is special because it is used as a "welcome page" if it exists, which means it will be served up as the root resource, i.e. at http://localhost:8080/ in our example. So create this file:

src/main/resources/static/index.html

when you restart the app you will see the HTML at http://localhost:8080/.
