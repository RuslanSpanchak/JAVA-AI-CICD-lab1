# AI Agent CI/CD Lab — Java + Maven + JUnit

Навчальний кросплатформний проєкт для лабораторної роботи **«Проєктування AI-агента для автоматизації розробки та CI/CD»**.

* **Студент:** Спанчак Руслан Ігорович
* **Група:** КІ-409
* **Варіант: 5** (Java / Maven / JUnit 5)
* **JDK:** 21
* **Складання:** Apache Maven
* **CI:** GitHub Actions — Windows, Linux і macOS

## Що містить проєкт

1. `HelloWorldApp` — мінімальний кросплатформний консольний застосунок, який виводить `Hello, World!`.
2. `BasicAddition` і `BasicAdditionTest` — приклад логіки та її перевірки за допомогою JUnit 5.
3. `TextAnalyzer` — додатковий навчальний приклад, який рахує слова, Unicode-коди символів і рядки.
4. AI-агент із manifest, трьома skills, п'ятьма операційними commands і командою-orchestrator `init`.
5. Скрипти локальної перевірки для Windows (`scripts/ci.bat`) та Linux/macOS (`scripts/ci.sh`).
6. GitHub Actions workflow із матрицею трьох ОС та завантаженням створеного JAR як artifact.

## Вимоги

* JDK 21;
* Apache Maven 3.9.x або сумісна версія;
* Git;
* GitHub Copilot у редакторі, який підтримує agent profiles, prompt files і agent skills, якщо потрібно запускати агента через Copilot.

## Локальне складання й запуск

З кореня репозиторію виконай:

```bash
mvn -B --no-transfer-progress clean verify
java -jar target/hello.jar
```

Очікуваний вивід останньої команди:

```text
Hello, World!
```

Для повного локального циклу, який також створює копію виконуваного JAR у `build/hello.jar`:

* **Windows:** `scripts\\ci.bat`
* **Linux/macOS:** `bash scripts/ci.sh`

Обидва скрипти виконують Maven build/test, створюють `build/hello.jar` і запускають саме цей артефакт. Каталоги `target/` та `build/` мають бути виключені з Git через `.gitignore`.

Додатковий текстовий аналізатор можна запустити так:

```bash
java -cp target/hello.jar com.example.textanalyzer.TextAnalyzerApp "Hello world"
```

## Використання AI-агента

Профіль агента: `.github/agents/build-engineer.agent.md`.

Skills у `.github/skills/`:

* `project-scaffold` — структура і початковий код;
* `build-and-test` — Maven/JUnit і перевірка виконуваного JAR;
* `github-actions` — CI workflow та артефакти.

Prompt-команди у `.github/prompts/`:

* `git-init.prompt.md` — перевірка Git та `.gitignore`;
* `create-project.prompt.md` — створення/перевірка коду й тесту;
* `create-build.prompt.md` — Maven-конфігурація;
* `create-actions.prompt.md` — CI workflow;
* `check.prompt.md` — локальний аудит;
* `init.prompt.md` — orchestrator повного процесу.

У Copilot Chat вибери агент `build-engineer`, а далі запусти `/init`, якщо твоя версія редактора підтримує prompt files як slash-команди. Перед прийняттям змін переглянь diff і запускай перевірки. Агент не має робити commit/push автоматично, видаляти файли або працювати із секретами.

## CI/CD

`.github/workflows/ci.yml` реагує на push, pull request і ручний запуск. Matrix має виконувати `scripts/ci.sh` на Linux/macOS і `scripts/ci.bat` на Windows. Після успіху JAR завантажується як artifact для кожної ОС. Вважай CI успішним лише після фактичного зеленого запуску у вкладці **Actions** на GitHub.

## Документація й докази

* Архітектура агента: [`docs/architecture.md`](docs/architecture.md)
* Інструкція запуску: [`docs/usage.md`](docs/usage.md)
* Шаблон журналу AI-взаємодії: [`docs/ai-log-template.md`](docs/ai-log-template.md)

Журнал заповнюй фактичними запитами до AI, рішеннями, перевірками й помилками. Не вигадуй журнальні записи та не додавай паролі, токени чи приватні ключі.

