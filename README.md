[![Build Status](https://travis-ci.org/bug-muffin/tic-tac-toe.svg?branch=master)](https://travis-ci.org/bug-muffin/tic-tac-toe)

# Tic Tac Toe

Tic tac toe is a console application built with Scala. The classic game of tic tac toe is a two player game where players trade turns placing a mark on a square board until either one player has won, or the game results in a draw. A player can win by placing three consecutive marks, either horizontally, vertically, or diagonally

```scala
   X | X | X       X |   |         X |   |
  ===+===+===     ===+===+===     ===+===+===
     |   |         X |   |           | X |
  ===+===+===     ===+===+===     ===+===+===
     |   |         X |   |           |   | X
```

## Requirements

* [Java](https://java.com/en/download/)
* [SBT](http://www.scala-sbt.org/0.13/docs/Setup.html)

## Running the Application

In your desired location from the terminal, clone the repo

```scala
git clone git@github.com:NicoleCarpenter/tic-tac-toe-scala.git
```

Then `cd` into the application's root directory

```scala
cd tic-tac-toe-scala
```

This application is built with SBT, a build tool similar to Gradle and Maven for Scala. To run the application, type

```scala
sbt run
```

## Running the Tests

From the root directory, run the tests with

```scala
sbt test
```