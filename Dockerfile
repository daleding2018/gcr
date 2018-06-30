FROM java:alpine
ADD /app.jar //
ENTRYPOINT ["/usr/bin/java","-jar","/app.jar"]
