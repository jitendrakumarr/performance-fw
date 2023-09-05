# Setup in local machine/IDE

```
1. Clone this repo and import as maven project.
2. Setup your IDE for scala, plugin is needed.
3. Java(11) and mvn should be configured.
```

# Execute the script specify class and env

```
Syntax: 
mvn gatling:test -Dgatling.simulationClass=simulations.<Scala_Class_Name_Without_Extension> -Dusers=1 -Dramp=1

e.g. mvn gatling:test -Dgatling.simulationClass=simulations.AuthorsSimulation -Dusers=1 -Dramp=1

This will execute the class mentiond in the pom.xml file on qa env.
    e.g. mvn gatling:test -Denv=qa -Dgatling.simulationClass=simulations.AuthorsSimulation

If env is also not provided then env will be picked from pom.xml only
    e.g. mvn gatling:test
    
```