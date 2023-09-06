# Setup in local machine/IDE

```
1. Clone this repo and import as maven project.
2. Setup your IDE for scala, plugin is needed.
3. Java(11) and mvn should be configured in the system.
```

# Execute the script specify simulation class, env, users and rampUp time in seconds.

```
Syntax: 
mvn gatling:test -Dgatling.simulationClass=simulations.<Scala_Class_Name_Without_Extension> -Dusers=1 -Dramp=1

e.g. mvn gatling:test -Dgatling.simulationClass=simulations.AuthorsSimulation -Dusers=1 -Dramp=1

This will execute the class mentiond in the pom.xml file on qa env.
    e.g. mvn gatling:test -Denv=qa -Dgatling.simulationClass=simulations.AuthorsSimulation

If env is also not provided then env will be picked from pom.xml only
    e.g. mvn gatling:test
    
```

# Scripting

```
test data files: stored in src/test/resources/data
environment config: stored in src/test/resources e.g qa.conf

we have to write our journey(API call sequence) in journey package under src/test/scala.

the load simulation setup and journey call in under simulation package under src/test/scala.



```