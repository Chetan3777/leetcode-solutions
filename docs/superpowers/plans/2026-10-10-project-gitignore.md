# Project Git Ignore Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Add root ignore rules suited to the Java 21, Maven, Spring Boot project and keep the entire IntelliJ `.idea/` directory out of version control.

**Architecture:** Use one root `.gitignore` with only patterns evidenced by the project: Maven build output, compiled classes, IntelliJ settings, and macOS Finder metadata. Keep application files, Maven wrapper scripts, and Maven project metadata trackable.

**Tech Stack:** Java 21, Maven, Spring Boot 4.1.1, IntelliJ IDEA, macOS.

## Global Constraints

- Ignore `target/`, `*.class`, `.idea/`, and `.DS_Store`.
- Keep `mvnw`, `mvnw.cmd`, `pom.xml`, and application sources unignored.
- Do not add broad IDE, editor, or environment-specific patterns beyond this scope.

---

### Task 1: Add project-specific ignore rules

**Files:**
- Create: `.gitignore`

**Interfaces:**
- Consumes: The project uses Maven, Java 21, Spring Boot, IntelliJ IDEA, and macOS.
- Produces: Root Git ignore rules for generated Maven output, compiled classes, IntelliJ configuration, and macOS metadata.

- [ ] **Step 1: Create the root `.gitignore`**

Add exactly these patterns:

```gitignore
target/
*.class
.idea/
.DS_Store
```

- [ ] **Step 2: Verify generated and local files are ignored**

Run:

```bash
git check-ignore -v target/example.class .idea/misc.xml .DS_Store
```

Expected: Each path is reported as ignored by `.gitignore`.

- [ ] **Step 3: Verify project files remain trackable**

Run:

```bash
git check-ignore mvnw mvnw.cmd pom.xml src/main/java/com/leetcode/solutions/SolutionsApplication.java
```

Expected: No paths are reported and the command exits with status 1, meaning these files are not ignored.
