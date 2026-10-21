---
name: create-actions
description: "Створює CI для Java/Maven на Linux, Windows і macOS через окремі скрипти складання."
agent: build-engineer
---

Застосуй `.github/skills/github-actions/SKILL.md`.
Створи або онови `.github/workflows/ci.yml`, щоб він:
- запускався на push до `develop`, `main`, `master` і `feature/**`, pull_request до `develop`, `main` або `master`, а також вручну;
- використовував одну job з matrix `ubuntu-latest`, `windows-latest`, `macos-latest`;
- виконував checkout і налаштовував Temurin JDK 21 з Maven cache;
- на Linux/macOS запускав `bash ./scripts/ci.sh`, а на Windows — `scripts\ci.bat`; не дублював команду Maven у YAML;
- після успішного скрипту завантажував `build/hello.jar` як artifact із назвою, що містить ОС, і падав, якщо файл не створено;
- використовував `permissions: contents: read` і не вимагав секретів.
Не стверджуй, що CI пройшов на GitHub, доки немає реального запуску.
