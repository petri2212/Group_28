
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
// UI ui = new ConsoleUI();
UI ui = new GraphicUI();
```

Right click on the MyShelfie.java file and select
```bash
Run As/Java Application
```


## Documentation

The main function is placed inside the MyShelfie.java class, under the "myshelfie" package.

The project takes advantage of the inheritance in several occasions.
An example could be found looking at the MVC pattern implementation, under the "gui" package or the Proxy pattern implementation, under the "board" package.

The usage of the keywords "super" and "this" can be basically found anywhere
inside the classes when needed, a quick example can be found in the constructor
of the Bookshelf object and inside its "tryAdd" methods.

Some methods have been overloaded like the "isThereEnoughSpace" method of the
Bookshelf class. Futhermore, there are some methods that have been overrided
to do specific tasks such as the "fillDeckGoals" abstract method of the Deck class.

The project has been organized in small packages to ease the code maintenance
and readability.

Since this project is based on the object programming paradigma, the use of
the keywords "implements" for the interfaces and "exteds" for the classes
can be found a lot of times. The abstract CommonGoal class for example implements two interfaces: Goal and DrawableObject.
Every other CommonGoal object derived from it extends for instance "CommonGoal".

An example of enum implementation is the BookshelfObject enumerator that not only enumerates few static objects but gives them attributes and methods. Same goes for the Images and Icons enumerators inside the "resource" package, where the various external resources are listed and given a method to load the specified resource (overriding the abstract "load" method of the Resource interface).

Inside the "gui.view" package there are the abstract views used to implement different types of the same view. This implementation are divided in the "console" and "graphic" packages.

The exception management has been used quite few times inside the project.
An example is the class MatrixCoords inside the "utils" package, that uses
a custom NegativeMatrixCoordsException exception derived from RuntimeException.
Also inside the "gui" package there are two custom exceptions designed for the
MVC pattern specifically.

For the collection and generics usage the Matrix class, inside the "utils" package, can sum the both. The class has been designed to be used in any program where a matrix is needed. For this reason the type of items contained inside the matrix is generic and the items are collected inside a Hashmap.

A lot of classes define their constants like the MyShelfie class that declare the maximum number of players and the minimum number of players, or simply the release version. The Board class and the Bookshelf class, beeing matrixes, declare the numer of rows and columns.

Inside the project, the attributes of the classes are often marked as "private" to avoid the direct manipulation of the data from other classes.
Also the "private" keyword can be found, often inside abstract classes.

The constructor of the PointsPageController class, placed under the "gui.controller" package sorts the list of players using the pints gained during the game. To do this we toke advantage of functional programming, using the lambda expression. In this way we avoided implementing the Comparable interface inside the Player class, or creating a dedicated Comparator.

As previously said, this project exploits the MVC pattern to separate the business logic from the graphical implementation of the views and their respective controllers.
The files views files and their respective controllers are located under the "gui" package, organized in the "view" and "controller" packages.

The "graphic" package also contains a package called "prototype". In here are contained the classes created with WindowBuilder plugin to generate the code automatically using the java.swing library. ATTENTION: this prototype classes should never be used inside the program!

To handle the board, the Proxy design pattern has been used in order to mirror the indices of the initial tile map. The tile map has been written in such way that is easy for the developers to transpose the phisical game board into a bidimensional array but this caused a not-so-logical indicization of the array.

Last but not least, the game is managed by a state machine located inside the GameManager.java class, placed inside the "myshelfie" package.


## Authors

- [@Andrei Petrisor ](https://github.com/petri2212)
- [@Andrea Rusconi ](https://github.com/andreaRusconl)
- [@Andrea Zanetti ](https://github.com/azanetti6)
- [@Fabio Mariani ](https://github.com/FabioMarianii)

