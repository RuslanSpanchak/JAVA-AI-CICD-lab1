---
name: create-project
description: "Створює або перевіряє мінімальний Hello World-проєкт і JUnit-приклад BasicAddition."
agent: build-engineer
---

Застосуй `.github/skills/project-scaffold/SKILL.md`.
1. Спочатку проаналізуй наявні файли й збережи сумісний код `TextAnalyzer`, якщо він існує.
2. Переконайся, що в `src/main/java/com/example/hello/HelloWorldApp.java` є головний клас, який виводить `Hello, World!`.
3. Переконайся, що `BasicAddition` має статичний метод `add(int, int)`.
4. Створи/перевір `src/test/java/com/example/hello/BasicAdditionTest.java`; тести повинні покривати додатні числа, від'ємне число та додавання нуля.
5. Дотримуйся стандартної Maven-структури та не змінюй інші файли без потреби.
6. Підсумуй, які файли створені/змінені, і назви неперевірені аспекти. Не вигадуй результатів запуску тестів.
