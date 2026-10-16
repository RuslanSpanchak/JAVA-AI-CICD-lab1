---
name: create-build
description: "Створює або перевіряє Maven-конфігурацію для Java 21 і JUnit 5."
agent: build-engineer
---

Застосуй `.github/skills/build-and-test/SKILL.md`.

1. Переглянь вихідний код, тести й наявний `pom.xml`.
2. Переконайся, що проєкт використовує Java 21, JUnit Jupiter із тестовою областю видимості, Maven Compiler Plugin, Maven Surefire Plugin і Maven JAR Plugin із головним класом `com.example.textanalyzer.TextAnalyzerApp`.
3. Збережи стандартну структуру Maven і стабільні версії залежностей/плагінів, явно задані в `pom.xml`.
4. Не додавай зайві залежності. Не змінюй тести так, щоб приховати помилки.
5. За можливості запусти `mvn -B clean verify` і наведи фактичний результат; якщо Maven недоступний, чітко зазнач це.
