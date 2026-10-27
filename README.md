# Project ZAGS

Автотесты для системы ЗАГС: API- и UI-тесты регистрации услуг (рождение, смерть, брак) с отчётами Allure и запуском по расписанию в GitHub Actions.

[![Scheduled ZAGS Tests](https://github.com/solar-owl/Project_ZAGS/actions/workflows/scheduled-tests.yml/badge.svg)](https://github.com/solar-owl/Project_ZAGS/actions/workflows/scheduled-tests.yml)

---
## Содержание

- [О проекте](#-о-проекте)
- [Технологии](#-технологии)
- [Требования](#-требования)
- [Быстрый старт](#-быстрый-старт)
- [Запуск тестов](#-запуск-тестов)
- [Allure-отчёт](#-allure-отчёт)
- [CI/CD](#-cicd)
- [Параллельный запуск UI-тестов через Selenoid](#параллельный-запуск-ui-тестов-через-selenoid)

---
## О проекте
`Project_ZAGS` — набор автоматизированных тестов для проверки сценариев
**регистрации услуг**:

- **Рождение** (`birth`) — заявление о рождении ребёнка;
- **Смерть** (`death`) — заявление о смерти;
- **Брак** (`marriage`) — заявление о заключении брака.

Тесты покрывают  **API** (валидация запросов/ответов) и **UI** (заполнение форм, проверка результата в интерфейсе).

**Ключевые возможности:**
- Allure-отчёты с шагами;
- TestNG-слушатель (`ScreenshotListener`) — автоматические скриншоты при падении;
- Логирование через Log4j(консоль + файл);
- Cucumber-сценарий с русскоязычным `feature`-файлом;
- Запуск по расписанию в GitHub Actions с отправкой отчёта на email.

---

## Технологии

| Слой | Технология             | Назначение |
|---|------------------------|---|
| Язык | **Java 27**            | Основной язык проекта |
| Сборка | **Maven**              | Управление зависимостями и жизненным циклом |
| Тесты | **TestNG**             | Фреймворк для запуска и организации тестов |
| BDD | **Cucumber**           | Описание сценариев на Gherkin |
| UI | **Selenium WebDriver** | Автоматизация браузера |
| API | **Rest Assured**       | Тестирование HTTP-эндпоинтов |
| Отчёты | **Allure**             | Наглядные отчёты со шагами |
| Логи | **Log4j 2**            | Логирование в консоль и файл |
| CI | **GitHub Actions**     | Запуск по расписанию и вручную |

---

## Требования

- **JDK 27**;
- **Maven 3.8+**;
- **Google Chrome**;
- **Allure CLI**  для локального просмотра отчёта).

---

## Быстрый старт

```bash
# 1. Клонировать репозиторий
git clone https://github.com/solar-owl/Project_ZAGS.git
cd Project_ZAGS

# 2. Собрать проект
mvn clean compile

# 3. Запустить все тесты
mvn clean test
```

---

## Запуск тестов

```bash
mvn clean test
```

---

## Allure-отчёт

```bash
# Генерация отчёта
mvn clean test allure:report
```

Отчёт появится в target/allure-report/.

```bash
# Просмотр локально
allure serve target/allure-results
```

---

## CI/CD
Проект использует **GitHub Actions**. Конфигурация — `.github/workflows/`.

Workflow «Scheduled ZAGS Tests» запускается:

* ежедневно по 6:17 MCK;

* вручную через workflow_dispatch (вкладка Actions → Run workflow).

---

## Параллельный запуск UI-тестов через Selenoid

UI-тесты запускаются параллельно в трёх браузерах (Chrome, Firefox, Edge)
через Selenoid. Состояние сессий и экран браузеров можно смотреть в selenoid-ui.
API-тесты запускаются отдельно, параллельно по методам.

### Подготовка окружения

1. Создать сеть Docker (один раз):
```bash
   docker network create selenoid
```
2. Скачать образы браузеров:
```bash
   docker pull selenium/standalone-chromium:latest
   docker pull selenium/standalone-firefox:latest
   docker pull --platform linux/amd64 selenium/standalone-edge:latest
```
3. Запустить Selenoid и UI:
```bash
   docker compose up -d
```
4. Проверить:
    - Selenoid: http://localhost:4444/status (должны быть chrome, firefox, MicrosoftEdge)
    - UI: http://localhost:8080

### Запуск тестов

```bash
mvn clean test
```

По очереди выполняются `testng.xml` (API) и `testng-ui.xml` (UI).