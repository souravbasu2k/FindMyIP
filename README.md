# FindMyIP

`FindMyIP` is an Android library that fetches IP information from a public API and displays it using Jetpack Compose. This library is built with Kotlin, uses Retrofit for networking, and integrates Jetpack Compose for UI components. It is designed to be easily integrated into any Android application.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Libraries and Dependencies](#libraries-and-dependencies)
- [Contributing](#contributing)
- [License](#license)

## Overview

The `FindMyIP` library provides a simple and efficient way to fetch IP information and display it in an Android application. It utilizes Retrofit for network calls and Jetpack Compose for modern, declarative UI.

## Features

- Fetch IP information from a public API (https://ipapi.co/json/).
- Display IP information using Jetpack Compose.
- Handle success and error states with appropriate UI feedback.
- Built with Kotlin and designed for easy integration.

## Setup Instructions

To integrate `FindMyIP` into your Android project, follow these steps:

1. **Include the Library in Your Project:**

   If you're using `FindMyIP` as a module, include it in your project by adding the following to your `settings.gradle.kts` file:

   ```kotlin
   include(":FindMyIP")
   project(":FindMyIP").projectDir = file("../FindMyIP") // Adjust the path as necessary
