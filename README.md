# spring-applications
Web applications using spring boot and spring mvc

# to serve jsp pages from a web app using spring boot
Add tomcat-jasper dependency in pon=m file, the tomcat jasper version should be same as embedded tomcat serevr

# annotaions
@Autowired - wires dependencies based on their types
@Qualifier - wies depedencies based on their names

# bean scopes
Singleton and prototype (these are main in terms of spring framework, there are also request and session scopes in case of web dev)
By default "singleton" is the scope of all beans, with this scope bean objects are created as soon application is up and running
if we specify "prototype" scope  (@Scope(value="prototype")), bean object is created only when the getBean() method is called 
or the object is called to access some functionality
