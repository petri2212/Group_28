
# My Shelfie - Digital Edition

This project is about the digitalization of the game "My Shelfie" from Cranio Creations taking advantage of object programming in Java.

Minimum requirements: Java version 11 or later

https://www.craniocreations.it/prodotto/my-shelfie





## Run Locally

Clone the project

```bash
  git clone git@github.com:petri2212/Group_28.git
```

Import the project in Eclipse and locate the MyShelfie.java file inside the "myshelfie" package.

Choose the type of user interface you want to run, e.g.:

```bash
  UI ui = new ConsoleUI();
//UI ui = new GraphicUI();
```

Right click on the MyShelfie.java file and select
```bash
Run As/Java Application
```


## Documentation

The main function is placed inside the MyShelfie.java class, under the "myshelfie" package.

The MyShelfie.java class contains two variables which define what type of user interface will be used by the program. Right now there are two types of user interface: Console User Interface, used for debug purpouses and the Graphic User Interface, meant as final ui for the game.

This project exploits the MVC pattern to separate the business logic from the graphical implementation of the views and their respective controllers.

The files views files and their respective controllers are located under the "gui" package, organized in the "view" and "controller" packages.

Inside the "view" package there are the abstract views used to implement different types of the same view. This implementation are divided in the "console" and "graphic" packages.

The "graphic" package also contains a package called "prototype". In here are contained the classes created with WindowBuilder plugin to generate the code automatically using the java.swing library. ATTENTION: this prototype classes should never be used inside the program!

Inside the "goal" package are stored the personal and common goal cards, placed in their respective packages. The cards are instantiated inside decks, placed under the "deck"package.

To handle the board, the Proxy design pattern has been used in order to mirror the indices of the initial tile map. The tile map has been written in such way that is easy for the developers to transpose the phisical game board into a bidimensional array but this cause a not-so-logical indicization of the array.

The game is managed by a state machine located inside the GameManager.java class, placed inside the "myshelfie" package.

Inside the "utils" package there are few generic classes that can be used outside this project and are standalone objects useful for general purposes.


## Authors

- [@Andrei Petrisor ](https://github.com/petri2212)
- [@Andrea Rusconi ](https://github.com/andreaRusconl)
- [@Andrea Zanetti ](https://github.com/azanetti6)
- [@Fabio Mariani ](https://github.com/FabioMarianii)


