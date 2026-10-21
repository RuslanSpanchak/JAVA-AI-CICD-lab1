---
name: check
description: "Перевіряє структуру AI-агента, безпеку Git, Maven build, JUnit, скрипти та CI workflow без зміни вихідних файлів."
agent: build-engineer
---

Використай skills `project-scaffold`, `build-and-test` і `github-actions` як контрольні списки. Це read-only аудит tracked source/configuration: не редагуй вихідні файли, не створюй commit і не публікуй зміни.
1. Перевір наявність manifest, трьох skills, п'яти операційних prompt-команд і orchestrator `init`.
2. Перевір `pom.xml`, `HelloWorldApp`, `BasicAddition`, `BasicAdditionTest`, наявний додатковий код, `scripts/ci.sh`, `scripts/ci.bat` і `.github/workflows/ci.yml`.
3. Виведи `java -version` і `mvn -version`.
4. Виконай локальний CI-скрипт: у Windows `scripts\ci.bat`; на Linux/macOS `bash scripts/ci.sh`. Це може створити ігноровані `target/` і `build/`, але не змінюй tracked source/config files.
5. Переконайся, що `build/` і `target/` ігноруються Git через `git check-ignore -v build/hello.jar target/hello.jar`.
6. Переглянь workflow: три ОС, push/pull_request, checkout, setup-java, виклик скриптів та upload artifact. Якщо YAML-linter недоступний, чітко зазнач це.
7. Зафіксуй фактичну кількість тестів із Surefire report, шлях до JAR і статус скрипту. Не стверджуй, що remote CI пройшов без запуску GitHub Actions.
