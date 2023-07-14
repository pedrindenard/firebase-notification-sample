## Example of Push Notifications using Firebase

This project is a practical example of implementing push notifications in an Android application using Firebase Cloud Messaging (FCM). The goal is to demonstrate how to send and receive remote notifications, as well as perform basic operations on a database.

### Features and Functionality

- Sending push notifications to Android devices using FCM.
- Integrated database for storing notification messages.
- Inserting, removing individual, and bulk removal of messages in the database.
- Using the concept of `Flow` to asynchronously and reactively retrieve messages from the database.

### Technologies Used

- Programming Language: Kotlin.
- Firebase Cloud Messaging (FCM) for sending and receiving push notifications.
- Android Room for storing notification messages.
- Coroutines for asynchronous programming and data flow management.

### Prerequisites

- Android device or emulator.
- Firebase account and configured project.
- Internet connection.

To generate the access token, you can use this project also built in Kotlin:
[Google Access Token](https://github.com/pedrindenard/google-access-token/)

### Setup and Usage

1. Clone the repository to your local development environment.
2. Open the project in Android Studio.
3. Configure Firebase in the project following the instructions from the [Firebase Console](https://console.firebase.google.com/).
4. Add the `google-services.json` configuration file provided by Firebase to the `app` folder of the project.
5. Make any necessary changes to customize the project (e.g., set the app's title and icon).
6. Run the application on your Android device or emulator.

### Contribution

Contributions to improve this project are welcome! Feel free to open issues and submit pull requests with your suggestions.

### Acknowledgements

- [Firebase](https://firebase.google.com/) for providing a comprehensive platform for mobile app development and cloud services.
- [Firebase Cloud Message Docs](https://firebase.google.com/docs/cloud-messaging/) full firebase documentation on cloud message and getting token using new API
- [Firebase Google Cloud](https://console.cloud.google.com/iam-admin/serviceaccounts/) where you will create your access key and get the Json file for creating the access token
- All the developers and open-source projects whose contributions were utilized in this project.

We hope that this example of Push Notifications using Firebase is helpful to you in your mobile app development. Feel free to explore the code, learn from it, and adapt it to your specific needs. If you have any questions, refer to the official documentation of Firebase and Android for more information on the features and concepts covered in this project.