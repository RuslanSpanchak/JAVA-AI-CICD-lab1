@echo off
setlocal

rem Always run from the repository root, regardless of the caller's directory.
cd /d "%~dp0.."

call mvn -B --no-transfer-progress clean verify
if errorlevel 1 exit /b 1

if not exist build mkdir build
copy /Y target\hello.jar build\hello.jar >nul
if errorlevel 1 exit /b 1

rem Smoke-test the same executable artifact that will be uploaded by CI.
java -jar build\hello.jar
if errorlevel 1 exit /b 1

exit /b 0
