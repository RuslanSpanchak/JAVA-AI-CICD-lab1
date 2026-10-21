---
name: create-build
description: "Налаштовує Maven для Java 21, JUnit 5 та виконуваного target/hello.jar."
agent: build-engineer
---

Застосуй `.github/skills/build-and-test/SKILL.md`.
1. Переглянь код, тести й наявний `pom.xml`.
2. Переконайся, що Maven використовує Java 21, JUnit Jupiter (test scope), Maven Compiler Plugin, Surefire Plugin і Maven JAR Plugin.
3. Налаштуй фінальне ім'я артефакту `hello.jar` і `Main-Class` `com.example.hello.HelloWorldApp`.
4. Збережи залежності й налаштування, які ще використовує проєкт; не додавай зайвих бібліотек.
5. Запусти `mvn -B --no-transfer-progress clean verify`, якщо інструменти доступні. Далі перевір `java -jar target/hello.jar`.
6. Наведи фактичні результати build та тестів. Якщо команда не запускається або падає, зазнач точну причину.
