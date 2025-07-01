# Farest's API!
[![Static Badge](https://img.shields.io/badge/farests--api-%2300AF5C?logo=modrinth&label=modrinth)](https://modrinth.com/mod/farests-api)
## Features
* Custom Note Block Instruments
* Registry helper classes
* Item Setting extensions
* Easy access to certain constructors and objects
* And there's more to come!
## Adding to a Project
Farest's API can be added to your project via [Modrinth's maven](https://support.modrinth.com/en/articles/8801191-modrinth-maven).
### build.gradle
```gradle
repositories {
  exclusiveContent { // Only check Modrinth Maven for Modrinth mods
    forRepository {
      maven {
        name = "Modrinth"
        url = "https://api.modrinth.com/maven"
      }
    }
    filter {
      includeGroup "maven.modrinth"
    }
  }
}

dependencies {
  modImplementation "maven.modrinth:farests-api:${project.farests_api_version}"
}
```

### gradle.properties
```properties
# Dependencies
farests_api_version=[MOD VERSION]
```
