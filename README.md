# Java Selenium Framework

This repo runs Selenium UI tests against the LocalAutomationApp. CI builds and serves the app before running TestNG tests.

## Local Setup

1) Clone LocalAutomationApp next to this repo (or set `LOCAL_AUTOMATION_APP_DIR` for your own scripts):
```bash
git clone git@github.com:tomHHuangJB/LocalAutomationApp.git /Users/tomhuang/prog/LocalAutomationApp
```

2) Run the app locally (same flow as CI):
- Build backend and frontend, then start them on:
  - `http://localhost:3001/health`
  - `http://localhost:5173`

3) Run tests:
```bash
mvn clean test -DbaseUrl=http://localhost:5173 -Dheadless=true
```

## CI Setup (Deploy Key)

GitHub Actions checks out `LocalAutomationApp` using a deploy key.

1) Generate a deploy key locally:
```bash
ssh-keygen -t ed25519 -C "java-selenium-ci-localautomationapp" -f ./local_automation_app_ci
```

2) Add public key to LocalAutomationApp:
- Settings → Deploy keys → Add deploy key
- Title: `java-selenium-framework-ci`
- Key: paste contents of `./local_automation_app_ci.pub`
- Leave "Allow write access" unchecked

3) Add private key to this repo:
- Settings → Secrets and variables → Actions → New repository secret
- Name: `LOCAL_AUTOMATION_APP_SSH_KEY`
- Value: paste contents of `./local_automation_app_ci`

4) Cleanup local key (optional):
```bash
rm -f ./local_automation_app_ci ./local_automation_app_ci.pub
```

## CI Workflow Details
- Workflow file: `.github/workflows/ci.yml`.
- Steps run in CI:
  - Checkout this repo and `LocalAutomationApp` (via `LOCAL_AUTOMATION_APP_SSH_KEY`).
  - Build backend + frontend, then serve the frontend on port 5173.
  - Wait for app health checks.
  - Run `mvn clean test -DbaseUrl=http://localhost:5173 -Dheadless=true`.
- Screenshots are saved to `artifacts/` on failure and uploaded as a workflow artifact.

## Notes
- Base URL and headless mode are read from system properties or env vars (`Config`), with defaults:
  - `baseUrl=http://localhost:5173`
  - `headless=false`
