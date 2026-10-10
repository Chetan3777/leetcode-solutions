# Project Git Ignore Design

## Goal

Add a root `.gitignore` tailored to this Java 21, Maven, Spring Boot project without excluding files needed to build or develop the application.

## Scope

Ignore Maven's `target/` output, compiled Java classes, IntelliJ IDEA's entire `.idea/` directory, and macOS `.DS_Store` metadata. Keep source code, resources, Maven wrapper scripts, and `pom.xml` trackable. Do not add broad IDE, editor, or environment-specific patterns beyond this scope.

## Approaches considered

- Minimal Java-only patterns: excludes compiled classes and Maven output, but leaves IntelliJ and macOS generated files visible.
- Focused project patterns (selected): adds `.idea/` and `.DS_Store` to the Java/Maven build patterns.
- Broad local-artifact patterns: also excludes logs, temporary files, and other common editor artifacts, but adds exclusions not evidenced by this project.

## Decision

Use the focused project patterns: `target/`, `*.class`, `.idea/`, and `.DS_Store`. The entire `.idea/` directory is local IDE configuration and is not required to share this project's build or source.

## Validation

Confirm the root ignore rules match generated build/IDE/OS artifacts while leaving `mvnw`, `mvnw.cmd`, `pom.xml`, and application sources unignored.
