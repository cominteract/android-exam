# android-exam

## Goal of the exam ##
To assess a developer's skills in terms of developing Android apps and decision-making on solving common development tasks.

## Tasks ##

- Fork this repository
- Create an Android project with the following features:
    - Loads and shows a list of Persons from a remote source(can be from some random source / https://randomuser.me)
    - Caches the loaded list of Persons
    - Prevents any loading from the remote source if the cache is available
    - Shows the full details of a Person on a separate screen
    - Each `Person` must have the following data: or use the API data https://randomuser.me
        - First name
        - Last name
        - Birthday
        - Age (derived from Birthday)
        - Email address
        - Mobile number
        - Address
        - Contact person
        - Contact person's phone number
    - Uses Clean Architecture
    - Uses Modularization 

- Send an email once done to arjay.paulino@cybilltek.com

Any libraries or tools of the developer's choosing may be used.

## Optional requirements ##

- Changes are committed following Git Flow
- Follows [this guideline](https://github.com/ribot/android-guidelines)
- Unit tests
- UI tests
- Material design
- Has proguard enabled
- Respects Activity/Fragment lifecycle
- `Mock` flavour that uses mock web server and doesn't have a `release` variant
- `Prod` flavour that uses a random remote source and doesn't have a `debug` variant
- Uses Model-View-ViewModel or similar design pattern
- Uses the Observable pattern
- Uses Dependency Injection
- Uses RxJava
