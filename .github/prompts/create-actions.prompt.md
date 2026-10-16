---
name: create-actions
description: "Створює або перевіряє GitHub Actions CI для Maven-проєкту на Linux, Windows і macOS."
agent: build-engineer
---

Застосуй `.github/skills/github-actions/SKILL.md`.

Створи або перевір `.github/workflows/ci.yml` так, щоб workflow:
- запускався на `push`, `pull_request` і через `workflow_dispatch`;
- мав матрицю `ubuntu-latest`, `windows-latest`, `macos-latest`;
- використовував `actions/checkout@v4` та `actions/setup-java@v4` з Temurin JDK 21 і кешем Maven;
- запускав `mvn -B --no-transfer-progress clean verify`;
- мав `permissions: contents: read` і не вимагав секретів.

Не стверджуй, що CI пройшов на GitHub, якщо workflow фактично не запускався там. Повідом результат статичної перевірки та що залишається перевірити після push.
