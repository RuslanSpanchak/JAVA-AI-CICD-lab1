# Інструкція користувача

## Локальна перевірка

1. Встанови JDK 21 та Maven.
2. Відкрий корінь репозиторію в терміналі.
3. Виконай `java -version` і `mvn -version`.
4. Запусти `mvn -B clean verify`.
5. Переконайся, що Maven завершився успішно і вивів звіт тестів. Детальні звіти містяться в `target/surefire-reports/`.
6. Запусти `java -jar target/text-analyzer-1.0.0.jar "Привіт світ"`.

## Команди AI

У сумісному Copilot Chat вибери/використай такі prompt files:

- `git-init.prompt.md`: перегляд стану Git і безпечна локальна ініціалізація за потреби;
- `create-project.prompt.md`: вимоги до застосунку й тести;
- `create-build.prompt.md`: Maven build і JUnit;
- `create-actions.prompt.md`: кросплатформний workflow;
- `check.prompt.md`: локальні перевірки;
- `init.prompt.md`: повний керований цикл із зупинкою на помилці.

Точний спосіб запуску prompt files залежить від версії редактора. Переконайся, що обраний AI-клієнт підтримує агентські профілі, prompt files і skills.

## Перевірка GitHub Actions

Після публікації репозиторію на GitHub відкрий вкладку **Actions** і переглянь запуск `Java Maven CI`. Workflow повинен мати три job-виконання за ОС: Linux, Windows і macOS. Успішний локальний build не гарантує, що всі remote runner-и теж пройдуть.
