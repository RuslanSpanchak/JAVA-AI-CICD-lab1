# Архітектура AI-агента

## 1. Призначення

`build-engineer` автоматизує контрольований цикл невеликого Java-проєкту: аналіз вимог, scaffold, Maven/JUnit, локальна перевірка, CI workflow і звіт про результат.

## 2. Manifest

`.github/agents/build-engineer.agent.md` визначає роль агента, контекст, доступні інструменти, межі безпеки, skills та критерії завершення. Manifest є профілем поведінки AI, а не shell-скриптом.

## 3. Skills

| Skill | Вхідні дані | Очікуваний результат | Перевірка |
|---|---|---|---|
| `project-scaffold` | вимоги, структура проєкту | Hello World, BasicAddition, JUnit-тест і README | структура Maven, пакети, очікуваний вивід |
| `build-and-test` | `pom.xml`, Java-код і тести | Maven-конфігурація та `target/hello.jar` | `mvn clean verify`, Surefire, запуск JAR |
| `github-actions` | Maven-проєкт і CI-скрипти | workflow з matrix та artifact upload | три ОС, правильний скрипт, файл артефакту |

Кожен skill має входи, порядок дій, виходи, умови перевірки та поведінку при помилці.

## 4. Commands

Файли `.github/prompts/*.prompt.md` — це іменовані prompt-команди для підтримуваних редакторів. Вони описують дію, яку AI виконує на запит користувача:

- `git-init` — перевірка Git та `.gitignore`;
- `create-project` — код Hello World і JUnit-приклад;
- `create-build` — конфігурація Maven;
- `create-actions` — workflow;
- `check` — аудит без зміни вихідних файлів;
- `init` — оркестратор.

Prompt-команда запускає інструкцію AI, а не є самостійною виконуваною shell-командою.

## 5. Дані та потік виконання

1. `git-init` перевіряє корінь, Git-стан і `.gitignore`.
2. `create-project` читає поточне дерево й додає лише відсутні файли.
3. `create-build` налаштовує Java 21, JUnit, Maven plugins і `target/hello.jar`.
4. `create-actions` перевіряє скрипти й налаштовує workflow.
5. `check` перевіряє структуру, запускає локальний скрипт, перевіряє ignored build outputs і звітує про результат.
6. `init` координує попередні кроки у фіксованій послідовності.

## 6. Оркестрація та обробка помилок

`init` перевіряє передумови, аналізує чинні зміни й завершує роботу при першій неподоланій помилці. Він не оголошує успіх, якщо Maven/test або локальний CI-скрипт не пройшли. Помилка має містити команду, фактичний результат і наступний безпечний крок. Оркестрація у prompt-файлі залежить від можливостей Copilot-клієнта; вона не є окремим детермінованим workflow engine.

## 7. CI/CD

`.github/workflows/ci.yml` використовує одну job з matrix `ubuntu-latest`, `windows-latest` і `macos-latest`. Після checkout та налаштування Temurin JDK 21 workflow викликає `scripts/ci.sh` на Linux/macOS або `scripts/ci.bat` на Windows. Сам скрипт запускає Maven build/test, копіює JAR у `build/hello.jar` та виконує smoke test. Після цього GitHub Actions завантажує JAR як artifact.

## 8. Безпека та повторний запуск

- Не просити або записувати секрети.
- Не запускати видалення файлів чи руйнівні Git-команди.
- Не виконувати commit/push автоматично.
- Не перезаписувати сумісний код без аналізу.
- Повторний запуск має перевіряти поточний стан і вносити лише потрібні зміни.
- `target/` і `build/` не потрапляють під Git.
