FROM openjdk:8

COPY ./build/libs/todolist-1.0.jar /app/todolist-1.0.jar

CMD java -jar -Dspring.profiles.active=$ENVIRONMENT /app/todolist-1.0.jar