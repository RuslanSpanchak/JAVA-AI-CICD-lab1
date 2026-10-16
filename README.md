# AI Agent CI/CD Lab — Java + Maven + JUnit

Навчальний кросплатформний проєкт для лабораторної роботи **«Проєктування AI-агента для автоматизації розробки та CI/CD»**. Репозиторій містить agent manifest, повторно використовувані skills, команди-промпти, оркестратор, Java-застосунок, JUnit-тести та GitHub Actions.

## Що робить застосунок

`TextAnalyzer` підраховує:
- слова, розділені пробільними символами;
- символи як Unicode code points (наприклад, `😀` рахується як один символ);
- рядки, розділені `\R` (у тому числі кінцевий порожній рядок після завершального переносу).

`null` відхиляється з `IllegalArgumentException`. Порожній рядок має 0 слів, символів і рядків.

## Вимоги

- JDK 21;
- Apache Maven 3.9.x або сумісна версія;
- GitHub Copilot у редакторі, який підтримує agent profiles, prompt files та agent skills, для використання конфігурації агента.

## Локальна збірка та тести

У корені репозиторію виконай:

```bash
mvn -B clean verify
```

Команда компілює проєкт, виконує JUnit-тести та створює JAR у `target/`.

Запуск застосунку з аргументами:

```bash
java -jar target/text-analyzer-1.0.0.jar "Hello world"
```

Приклад результату:

```text
Words: 2
Characters (Unicode code points): 11
Lines: 1
```

Якщо запускати без аргументів, програма запропонує ввести один рядок із клавіатури.

## Використання AI-агента

У GitHub Copilot Chat відкрий промпт-команду з каталогу `.github/prompts/` або запусти відповідну prompt file командою, яку підтримує твоя версія редактора:

- `git-init.prompt.md` — безпечна ініціалізація Git, якщо це ще не репозиторій;
- `create-project.prompt.md` — структура застосунку і тести;
- `create-build.prompt.md` — Maven-конфігурація;
- `create-actions.prompt.md` — CI workflow;
- `check.prompt.md` — локальна перевірка;
- `init.prompt.md` — оркестратор повного циклу.

Профіль агента: `.github/agents/build-engineer.agent.md`. Інструкції skills: `.github/skills/*/SKILL.md`.

Перед прийняттям будь-яких змін переглядай diff і запускай перевірки. Не передавай AI секрети. Агентні промпти забороняють автоматичні commit/push і руйнівні Git-операції.

## CI/CD

Файл `.github/workflows/ci.yml` запускає `mvn -B --no-transfer-progress clean verify` на `ubuntu-latest`, `windows-latest` і `macos-latest` під час `push`, `pull_request` або ручного запуску. Реальний стан усіх трьох середовищ треба підтвердити результатом workflow у вкладці **Actions** GitHub.

## Структура

```text
.github/
├── agents/build-engineer.agent.md
├── prompts/
│   ├── git-init.prompt.md
│   ├── create-project.prompt.md
│   ├── create-build.prompt.md
│   ├── create-actions.prompt.md
│   ├── check.prompt.md
│   └── init.prompt.md
├── skills/
│   ├── project-scaffold/SKILL.md
│   ├── build-and-test/SKILL.md
│   └── github-actions/SKILL.md
└── workflows/ci.yml
src/
├── main/java/com/example/textanalyzer/
│   ├── TextAnalyzer.java
│   └── TextAnalyzerApp.java
└── test/java/com/example/textanalyzer/TextAnalyzerTest.java
docs/
├── architecture.md
└── usage.md
pom.xml
README.md
.gitignore
```
