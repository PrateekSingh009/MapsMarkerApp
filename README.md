# Google Maps Marker App
Google Maps Marker App is an Android application developed to allow users to mark locations on Google Maps, save them to a database, and manage these markers efficiently.
It is built using Kotlin programming language and follows the MVVM architecture pattern for separation of concerns and maintainability.

## Features
- **MVVM Architecture**: Implements Model-View-ViewModel architecture for clean and maintainable codebase.
- **Kotlin Language**: Utilizes Kotlin features such as extension functions, higher-order functions, null safety, data classes, and lambda expressions.
- **Dagger Hilt**: Dependency injection is handled using Dagger Hilt for modularity and testability.
- **Room Database**: Utilizes Room database for data persistence, with Coroutines for background thread handling.
- **Google Maps Integration**: Incorporates Google Maps SDK to display an interactive map interface.
- **Marker Management**: Allows users to drop markers on the map, save them to the database with additional information, and retrieve saved markers for display on the map.
- **Marker Customization**: Provides clear distinction between dropped and saved markers in terms of styling.
- **Marker Deletion**: Enables users to delete saved markers from the map and database, with confirmation dialogs to prevent accidental deletions.
- **Address Retrieval**: Retrieves address information using the Geocoder API based on latitude and longitude.

## Technologies / Libraries Used
- Native Android
- Kotlin
- Google Maps SDK
- Dagger Hilt
- Room Database

## Installation

To install and run the Google Maps Marker App, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/PrateekSingh009/MapsMarkerApp.git
2. Open the project in Android Studio.
3. Generate and Add the Maps Api Key 
4. Build and run the project on an Android device or emulator.

## APK
 You can download the zip file of apk [here](https://drive.google.com/file/d/1BRINU2wmKyVuomcZQChqMWAeZTvclzcO/view?usp=sharing)
 
 ## Screenshots

### App Visual
<table>
  <tr>
    <td><img src="https://media.discordapp.net/attachments/874542599740989452/1220787079995326544/ss_1.jpg?ex=66103590&is=65fdc090&hm=a08c9c8eeb49740e953075a974e8be23c3b7d5369037676cfecaa2e8319a9391&=&format=webp&width=298&height=662" width=200 ></td>
    <td><img src="https://cdn.discordapp.com/attachments/874542599740989452/1220787081006153758/ss_4.jpg?ex=66103591&is=65fdc091&hm=5abd6f2b82ec1050bb14040ce9ede9fe69e32f47eab80508d1888e633cd43507&" width=200 ></td>
   <td><img src="https://cdn.discordapp.com/attachments/874542599740989452/1220787081442492466/ss_5.jpg?ex=66103591&is=65fdc091&hm=4dc029cee290ed79915f42a883c11f09b3c98184057bdaddabacd2e3a62707f3&" width=200 ></td>
  </tr>
  <tr>
    <td><img src="https://cdn.discordapp.com/attachments/874542599740989452/1220787081979232466/ss_6.jpg?ex=66103591&is=65fdc091&hm=a12b64aa443f8674414adfc8ef0302a0b5323d273fd1eb80981755803fbb444c&" width=200 ></td>
    <td><img src="https://cdn.discordapp.com/attachments/874542599740989452/1220787082411376710/ss_7.jpg?ex=66103591&is=65fdc091&hm=961742abd2e842722a88c0323321a0ba0d8cb45ca80b5e5d71436619ec3dab12&" width=200 ></td>
   <td><img src="https://cdn.discordapp.com/attachments/874542599740989452/1220787080637186109/ss_3.jpg?ex=66103591&is=65fdc091&hm=6a193fb4e807357c08d1dd923e8cfb59e4ad9bcac8a82ad437d3967554926892&" width=200 ></td>
  </tr>
 </table>
 
 ### Database
 
 <table>
  <tr>
    <td><img src="https://cdn.discordapp.com/attachments/874542599740989452/1220787082826481744/ss_1.png?ex=66103591&is=65fdc091&hm=dcd07e0b302856859fd48746cd4f5b167694445726ca3782a07520062d6342db&" width=600 ></td>
  </tr>
 </table>
