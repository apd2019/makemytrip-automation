# MakeMyTripAutomation — Checklists

Living document. Update these as you learn — especially the CI/CD one, since you're
learning GitHub Actions on the go. If something breaks and the fix isn't reflected in a
checklist below, add it before you move on.

---

## 1. New Test Creation Checklist

Run through this before you consider a test "done."

- [ ] Test class placed under `src/test/java/...` following existing package structure
- [ ] Class/method naming follows convention (e.g. `LoginTest`, `testValidLogin`)
- [ ] Test has a clear, single purpose — not testing multiple unrelated things in one method
- [ ] Assertions are meaningful (not just "page loaded") — actually verifies expected behavior
- [ ] No hardcoded waits (`Thread.sleep`) — uses explicit waits (`WebDriverWait`) instead
- [ ] No hardcoded test data that should come from config/data files
- [ ] Test does not depend on execution order or another test's leftover state
- [ ] Added to the correct TestNG group(s) (`smoke`, `regression`, `sanity`, etc.)
- [ ] Added/updated in `testng.xml` suite file if using suite-based execution
- [ ] Driver is properly initialized and torn down (no leaked browser sessions)
- [ ] Ran locally and passed at least once before pushing
- [ ] Ran locally in **headless** mode at least once (catches CI-only failures early)
- [ ] Added a row in the **Test Case Tracker** sheet (TC ID, status, class/method mapping)

---

## 2. Pre-CI-Push Checklist

Run before pushing to a branch that triggers GitHub Actions.

- [ ] Code compiles locally (`mvn clean compile`)
- [ ] All tests pass locally (`mvn clean test`)
- [ ] Tests pass locally **headless**, not just headed
- [ ] `pom.xml` Java version matches the `java-version` in the GitHub Actions workflow file
  *(this exact mismatch broke CI once — always double check both places)*
- [ ] No new hardcoded absolute file paths (e.g. local Windows/Mac paths to drivers/files)
- [ ] `ChromeOptions` includes both `--no-sandbox` and `--headless=new` for CI-safe execution
- [ ] No secrets, credentials, or API keys committed
- [ ] Commit message describes what changed and why
- [ ] Updated **Env & Version Log** if any dependency/version changed

---

## 3. Framework / Environment Setup Checklist

Check periodically, and whenever setting up on a new machine.

- [ ] `pom.xml` has correct `groupId`/`artifactId` and dependency versions pinned (not using
      unpinned `LATEST`/`RELEASE`)
- [ ] Selenium, TestNG, and WebDriverManager (or equivalent) versions are compatible with each
      other and with the Java version in use
- [ ] Java version consistent across: `pom.xml`, GitHub Actions workflow, local IDE (Eclipse)
      project settings
- [ ] Driver management strategy is consistent (WebDriverManager vs manually placed binaries)
- [ ] Base/parent test class exists for shared setup-teardown logic (avoid duplicating driver
      init in every class)
- [ ] Config values (base URL, timeouts, environment) are externalized, not hardcoded per test
- [ ] `.gitignore` excludes target/, IDE files, local driver binaries, and any local config
      with secrets

---

## 4. CI/CD Pipeline Checklist (GitHub Actions)

Since you're learning this from scratch — check this after every workflow change.

- [ ] Workflow YAML syntax is valid (no indentation errors)
- [ ] `java-version` in workflow matches `pom.xml` `<maven.compiler.release>` (or source/target)
- [ ] Correct trigger configured (`on: push`, `on: pull_request`, or both) for the branches you
      actually want
- [ ] Chrome/browser setup step present if not using a pre-installed browser action
- [ ] `ChromeOptions` in code includes `--headless=new` — CI has no display, this is
      non-negotiable (this exact gap caused `SessionNotCreatedException` once)
- [ ] Maven command in workflow matches what you run locally (`mvn clean test`, correct profile
      if any)
- [ ] Test reports/results are surfaced somewhere (uploaded as artifact, or at least visible in
      the Actions log) — don't let a red X be the only signal
- [ ] Workflow run reviewed end-to-end at least once after any change, not just "it went green"
- [ ] Any new secret/env var added via GitHub repo Settings → Secrets, never hardcoded

---

## 5. Definition of "Done" for a Test

A test is not done just because it passes once. It's done when:

- [ ] Passes 3 consecutive CI runs (not just locally)
- [ ] Passes in headless mode
- [ ] Has real assertions beyond "did the page load"
- [ ] Does not depend on another test running first
- [ ] Is tracked in the Test Case Tracker with correct status
- [ ] Any flakiness observed is logged in **Flaky & Known Issues**, not silently ignored

---

## 6. Weekly/Periodic Maintenance Checklist

Not per-commit — do this every week or two.

- [ ] Review **Flaky & Known Issues** sheet — anything still unresolved after multiple weeks?
- [ ] Review **Framework Backlog** — anything blocked that needs unblocking?
- [ ] Check for dependency updates (Selenium, TestNG, WebDriverManager) — update deliberately,
      not automatically, and log it in **Env & Version Log**
- [ ] Skim recent CI run history for patterns (same test failing intermittently, runs getting
      slower, etc.)
- [ ] Confirm README is still accurate if anything about setup/run steps changed

---

## Notes

- These checklists live in the repo (not just this file) so they evolve with the code —
  edit this file directly via PR/commit like any other project file.
- Pair this file with the **Test Tracker** workbook (Test Case Tracker, Flaky & Known
  Issues, Framework Backlog, Env & Version Log sheets) for anything that needs structured,
  filterable data rather than a checklist.
