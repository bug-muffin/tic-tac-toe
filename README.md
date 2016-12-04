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

This version plays agains an AI optimized with the [negamax](https://en.wikipedia.org/wiki/Negamax) algorithm.

## Dependencies

* [Java](https://java.com/en/download/) 1.8.0
* [sbt](http://www.scala-sbt.org/0.13/docs/Setup.html) 0.13.13
* [Scala](https://www.scala-lang.org/download/) 2.11.8

## Installing Dependencies

This application is built with sbt, a build tool for Scala similar to Java's Gradle and Maven. sbt eliminates the need to download Scala separately.

sbt is available for [Mac](http://www.scala-sbt.org/0.13/docs/Installing-sbt-on-Mac.html) through Homebrew

```scala
brew install sbt
```

[Windows](http://www.scala-sbt.org/0.13/docs/Installing-sbt-on-Windows.html) machines can download a Windows Installer [here](http://www.scala-sbt.org/0.13/docs/Installing-sbt-on-Windows.html)

Ubuntu users can use the following commands, with additional configuration notes available on sbt's [Linux Installations](http://www.scala-sbt.org/0.13/docs/Installing-sbt-on-Linux.html) page. You will also find ZIP and TGZ files there for manual installation. 

```scala
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
sudo apt-get update
sudo apt-get install sbt
```

## Running the Application

In your desired location from the terminal, clone the repo

```scala
git clone https://github.com/bug-muffin/tic-tac-toe.git
```

Then `cd` into the application's root directory

```scala
cd tic-tac-toe-scala
```

To run the application, type

```scala
sbt run
```

## Running the Tests

From the root directory, run the tests with

```scala
sbt test
```