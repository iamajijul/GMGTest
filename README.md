# GMGTest

This Application fetching user data by calling API and showing to user,also handling offline functionality.
This application build for Demo purpose.
The app follows the MVVM architecture with the repository pattern, alongside Dagger_Hilt for DI.

#### Folder structure

There are 6 main folders: base, db, di, helper, network, ui
* base: This folder contain all Base classes like BaseActivityClass
* db: This folder contain all Room database related work
* di: Contain Dagger_Hilt related files
* helper: Helper classes to build this application ex. extension class
* network: Retrofit network related classes present in this folder
* ui: All views related classes present in this folder. The app follows MVVM architecture coding pattern 
for this project.

### Design, libraries and other stuff applied

* Data binding
* Room
* Paging library for pagination
* ViewModel and LiveData
* Coroutines
* Dagger_Hilt for dependency injection
* Retrofit
* MVVM architecture + Repository pattern
* Navigation Architecture Component
* Constraint Layout
* Google Material Components

Whole project written in kotlin language.


### Permission!

1. Internet permission
2. Network State

### Note!
This app saving data for offline viewing, if user lose the internet connection
then this app will show the data from database.