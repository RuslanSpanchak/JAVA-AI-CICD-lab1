# Інструкція користувача

## 1. Вимоги

Переконайся, що встановлено JDK 21, Maven і Git:

```text
java -version
mvn -version
git --version
```

## 2. Складання та JUnit

З кореня репозиторію виконай:

```text
mvn -B --no-transfer-progress clean verify
```

Maven створює `target/hello.jar` і запускає тести JUnit 5. Звіти тестів знаходяться в `target/surefire-reports/`.

Запусти виконуваний JAR:

```text
java -jar target/hello.jar
```

Очікуваний вивід:

```text
Hello, World!
```

## 3. Повний локальний CI-скрипт

Скрипт збирає проєкт, запускає тести, копіює JAR до `build/hello.jar` і запускає створений файл.

- Windows Command Prompt або PowerShell: `scripts\ci.bat`
- Linux/macOS: `bash scripts/ci.sh`

Після успішного виконання перевір, що `target/` і `build/` ігноруються Git:

```text
git check-ignore -v target/hello.jar build/hello.jar
```

## 4. Запуск AI-агента

Відкрий корінь репозиторію у редакторі з підтримкою GitHub Copilot custom agents, skills і prompt files. У Copilot Chat вибери агента `build-engineer` і запусти `/init`.

Окремі prompt-команди:

- `git-init` — перевіряє Git і правила `.gitignore`;
- `create-project` — перевіряє Hello World та JUnit-приклад;
- `create-build` — налаштовує Maven і тестування;
- `create-actions` — створює/перевіряє workflow;
- `check` — запускає аудит і локальну перевірку;
- `init` — оркеструє процес у правильному порядку.

Точний спосіб запуску prompt files залежить від версії редактора. Якщо `/init` не з'являється, перевір, що відкрито правильний репозиторій і файли `.github/prompts/*.prompt.md` доступні редактору.

## 5. GitHub Actions

Після push відкрий вкладку **Actions**. Перевір job для `ubuntu-latest`, `windows-latest` і `macos-latest`. У кожному успішному job має бути artifact `hello-<OS>` із файлом `hello.jar`.

Локальна збірка не є доказом успішного remote CI. Збережи посилання на реальний запуск або скриншоти з трьома зеленими результатами.

## 6. Git-процес і pull request

Рекомендований процес:

1. `develop` — гілка розробки.
2. `feature/lab1-ai-agent` — гілка виконання роботи, створена від `develop`.
3. Створи змістовні коміти для агента/skills/commands, проєкту і CI.
4. Опублікуй feature-гілку та створи pull request до `develop` з назвою `lab1/finish`.
5. Додай у PR посилання на архітектуру, журнал AI, локальні перевірки й workflow.
6. Після перевірки об'єднай зміни відповідно до правил викладача. У цьому репозиторії основна гілка називається `main`; не створюй `master` без вимоги викладача.

Не виконуй force push, не зберігай секрети та не додавай `target/` або `build/` до Git.
