karuku
======

This is a demo of using Jersey client and server for evaluation of expressions on integers. Expressions are transmitted as application/xml with object structure.

Modules
-------

* *common*: contains object structure of expressions. It is an implementation of the object composite pattern. Expressions can accept evaluators. These expressions annotated to be convertible to XML using JAXB.

* *server*: contains evaluator for expresion and Jersey server (in Grizley webserver) for exposing evaluation as a web-service. Exposes information on this service as a WADL file (located at http://localhost:9998/application.wadl). Server can be started by `./start.sh` script after packaging (`mvn package`).

* *client*: uses generated from `application.wadl` expression classes and has a a simple client to connect to the server. There are some integration tests, which start server in separate thread (using command line) and test evaluation of expressions using client. Classes are generated using `mvn org.apache.cxf:cxf-wadl2java-plugin:wadl2java` command.