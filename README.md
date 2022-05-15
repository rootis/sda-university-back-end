# SDA University Back-end
## Create Database
``CREATE DATABASE sda2_university CHARACTER SET utf8 COLLATE utf8_general_ci;``
## Execute Tests:
``mvnw test``
## Execute Tests Without Integration Tests:
``mvnw test -DexcludedGroups="integration"``
## Build package
``mvnw clean package``
