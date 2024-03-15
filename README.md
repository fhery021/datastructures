# Template Project
This is a template project for Java CLI projects.

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=fhery021_cli-template&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=fhery021_cli-template)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=fhery021_cli-template&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=fhery021_cli-template)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=fhery021_cli-template&metric=coverage)](https://sonarcloud.io/summary/new_code?id=fhery021_cli-template)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=fhery021_cli-template&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=fhery021_cli-template)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=fhery021_cli-template&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=fhery021_cli-template)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=fhery021_cli-template&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=fhery021_cli-template)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=fhery021_cli-template&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=fhery021_cli-template)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=fhery021_cli-template&metric=bugs)](https://sonarcloud.io/summary/new_code?id=fhery021_cli-template)

You need to correct the links for these badges if create a new project from this template.

# KataLeanOn 
This repository contains Katas and their solutions in Java.

## 🥋 Human Readable Time

### Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99

MM = minutes, padded to 2 digits, range: 00 - 59

SS = seconds, padded to 2 digits, range: 00 - 59

The maximum time never exceeds 359999 (99:59:59)



### Build and Run the application with the following:
> gradle build

> gradlew run

On windows
> .\gradlew.bat run

## Git Conventional commits

Git hooks overview: https://www.greengeeks.com/tutorials/an-overview-of-git-hooks/
Guide: https://gist.github.com/qoomon/5dfcdf8eec66a051ecd85625518cfd13
Install git-conventional-commits: npm install --global git-conventional-commits <- The ugly regex things are implemented in this tool
Put this file in your repo root: git-conventional-commits.json  <- This is the config file for the previous tool. Here you can customize your rules, but the example in the next line is sufficient for the exam.
I have filled the json with the example from https://github.com/qoomon/git-conventional-commits
After clone or git init create this file: <repo_root>/.git/hooks/commit-msg
Write this to the commit-msg file

#!/usr/bin/env sh
commit_message="$1"
# exit with a non zero exit code incase of an invalid commit message

# use git-conventional-commits, see https://github.com/qoomon/git-conventional-commits
git-conventional-commits commit-msg-hook "$commit_message"


If you use Linux, make the commit-msg file executable.
