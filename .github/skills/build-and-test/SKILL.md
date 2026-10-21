---
name: build-and-test
description: "Перевіряє Maven-конфігурацію, збирає Java JAR, запускає JUnit та перевіряє виконуваний артефакт."
---

# Build and Test Skill

## Вхідні дані
- `pom.xml`, Java-код і JUnit-тести.
- Версія JDK, доступність Maven та попередні результати.

## Порядок роботи
1. Переконайся, що `java -version` і `mvn -version` працюють.
2. Перевір Java 21, JUnit Jupiter у test scope, Maven Compiler Plugin, Surefire і JAR Plugin.
3. Переконайся, що назва артефакту — `target/hello.jar`, а `Main-Class` — `com.example.hello.HelloWorldApp`.
4. Запусти `mvn -B --no-transfer-progress clean verify`.
5. Переглянь Maven summary та звіти в `target/surefire-reports/`.
6. Запусти `java -jar target/hello.jar` і перевір очікуваний вивід `Hello, World!`.
7. Для повного локального циклу виконай `scripts/ci.bat` у Windows або `bash scripts/ci.sh` у Linux/macOS. Скрипт створює `build/hello.jar`.
8. Якщо перевірка не пройшла, знайди першу суттєву помилку й запропонуй мінімальне виправлення. Не маскуй помилки.

## Очікуваний результат
- Фактичний результат Maven build/test.
- Виконуваний `target/hello.jar`.
- Після запуску CI-скрипту — `build/hello.jar`.

## Критерії перевірки
- Maven завершився з кодом 0.
- `BasicAdditionTest` пройшов; у звітах немає невдалих тестів.
- JAR запускається і друкує `Hello, World!`.
- `build/` виключено з Git.

## Типові помилки
Якщо Maven, JDK або мережа недоступні, зафіксуй блокер і не заявляй про успіх. Якщо тести не проходять, не змінюй тести так, щоб приховати дефект.
