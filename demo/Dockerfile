	FROM --platform=linux/amd64 openjdk:17
	EXPOSE 8080
	ADD target/app.jar app.jar
	ENTRYPOINT ["java", "-jar", "app.jar"]