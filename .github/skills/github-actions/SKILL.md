---
name: github-actions
description: "Створює або перевіряє GitHub Actions CI з матрицею Linux, Windows і macOS, запускаючи окремі build-скрипти."
---

# GitHub Actions Skill

## Вхідні дані
- Maven-проєкт, `scripts/ci.sh`, `scripts/ci.bat`.
- Версія JDK і цільові ОС.

## Порядок роботи
1. Переглянь поточний workflow і скрипти, щоб не створити дублікати.
2. Створи або онови `.github/workflows/ci.yml` із тригерами `push`, `pull_request` і `workflow_dispatch`.
3. Використай одну job з matrix: `ubuntu-latest`, `windows-latest`, `macos-latest`.
4. Виконай checkout і налаштування Temurin JDK 21 з Maven cache.
5. У workflow не дублюй build-команди Maven: на Linux/macOS викликай `bash ./scripts/ci.sh`, на Windows — `scripts\ci.bat`.
6. Скрипти мають виконувати Maven build/test, створювати `build/hello.jar` і перевіряти його запуск.
7. Завантажуй `build/hello.jar` як artifact окремо для кожної ОС. Не зберігай секрети у workflow.
8. Використовуй мінімальні дозволи `contents: read`.

## Очікуваний результат
`.github/workflows/ci.yml`, що запускає однаковий сценарій перевірки на трьох ОС і публікує JAR як workflow artifact.

## Перевірки
- У matrix присутні Linux, Windows та macOS.
- Для кожної ОС викликається відповідний скрипт.
- Після скрипту існує `build/hello.jar`.
- Відсутність артефакту призводить до помилки job.
- Реальний remote успіх підтверджено лише після запуску workflow на GitHub.

## Типові помилки
Якщо скрипт відсутній або завершується помилкою, виправ його до CI-запуску. Якщо локально неможливо перевірити YAML або віддалений runner, зазнач це як неперевірений крок.
