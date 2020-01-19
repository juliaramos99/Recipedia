# Recipedia
**Recipedia** is a recipe generator application that takes ingredient names provided by the user and generates a recipe that requires these ingredients.
This is our project for HackDavis2020.

The final project uses the Model-View-Controller (MVC) architectural pattern. We used JSON data retrieval and JavaFX interface.

# Files
The files inside this repository are:

* **HealthView.fxml** - View for project
* **HealthController.java** - Controller for project
* **HealthModel.java** - Contains public static void main to start the application
* **HealthMain.java** - Main program to run the application
* **badartistname.png** - Image displayed if an invalid recipe is found
* **gson-2.2.4.jar** - Required to parse JSON code returned
* **hamcrest-core-1.3.jar** - Required to run JUnit tests
* **junit-4.12.jar** - Required to run JUnit tests
* **README.md** - README file with details of this repository

# Getting Started
Make sure all files are in the same directory. Configure the gson-2.2.4.jar, hamcrest-core-1.3.jar, junit-4.12.jar files. 

# Operation
Run the HealthMain.java file and the interface for the application should appear. 
Enter a comma-seperated list of ingredients and click on the Search! button. The recipe's information will be displayed. 
Click next or previous to look at more recipes. An invalid or empty ingredients field will display an error message.

# Authors
* **Julia Beatriz Ramos**
* **Rami Mostafa**
* **Allan Yu**
* **Boei Lee**
