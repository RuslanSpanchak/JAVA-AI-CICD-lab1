#!/usr/bin/env bash
set -euo pipefail

# Always run from the repository root, regardless of the caller's directory.
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"
cd "${PROJECT_ROOT}"

mvn -B --no-transfer-progress clean verify

mkdir -p build
cp target/hello.jar build/hello.jar

# Smoke-test the exact artifact that will be uploaded by GitHub Actions.
java -jar build/hello.jar
