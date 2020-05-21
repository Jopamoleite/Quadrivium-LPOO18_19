
  

# LPOO_13 Quadrivium

  

A Tron-inspired game, with 4 different sub games, each with various levels of difficulty. As in the original game, the difficulty only increases once all the sub games have been beat once. The sub games are the following:

- (based on I/O Tower) the player must enter a tower within a time limit, while avoiding or destroying enemies.

- (based on MCP Cone) the player must ascend into a cone, without touching the wall in front of it (this wall can be destroyed by shooting at it).

- (based on Battle Tanks) the player drives a tank in a maze, attempting to kill all enemy tanks without dying.

- (based on Light Cycles) the player must guide a vehicle in an arena, while avoiding the trails left behind by the player and the enemy (or enemies).

  

By: João Leite (up201705312@fe.up.pt) and Márcia Teixeira (up201706065@fe.up.pt).

  

## Implemented Features

  

 ### Level Manager

 This feature stores the current level/game and manages the transitions between these. This is done by the use of the class "CurrentLevel" stores the current game (or menu). When a game ends, the CurrentLevel's "game" is updated to the menu, and when the user selects a sector in the menu, the level is updated accordingly (each sector is associated with a specific game). The information about whether the player passed or failed the game is given to the Level Manager after the game finishes. When all levels are cleared once, the difficulty is increased by 1 and the levels are reset.

  

 ### Menu

 Menu stores and displays the game's menu, where the player is free to walk and is able to select the Game he wants to play by pressing the Enter key on top of one of the level's sectors. Each sector corresponds to a fixed level.
 Screenshot of the Menu:![enter image description here](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/Menu.png "Menu")

  
  

## Planned Features

  

  ### Battle Tanks

 Game logic for Battle Tanks mini-game, to be implemented in the future.
 Rough sketch of the intended GUI:
![enter image description here](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/BattleTanks.png "Battle Tanks")

  

  ### I/O Tower

 Game logic for I/O Tower mini-game, to be implemented in the future.
 Rough sketch of the intended GUI:![enter image description here](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/IOTower.png "IO Tower")

  

  ### Light Cycles

 Game logic for Light Cycles mini-game, to be implemented in the future.
 Rough sketch of the intended GUI:
![enter image description here](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/LightCycles.png "Light Cycles")
  

  ### MCP Cone

 Game logic for MCP Cone mini-game, to be implemented in the future.
 Rough sketch of the intended GUI:![enter image description here](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/MCPCone.png "MCP Cone")

  

## Design

  

 ## General code structure

 ### Problem in Context
 Dividing each object into categories in order to facilitate changing the used GUI (if needed), as well as increasing code efficiency and organization

 ### The Pattern

 In order to overcome this problem, we adopted the MVC architectural pattern, which divides the code into a Model, a View and a Controller, each with their own unique responsabilities.

 The **Model** represents the object's data.

 The **View** displays the data from the model, and sends user actions to the controller.

 The **Controller** links model's data to the view, and interprets user actions.

 ### Implementation

 The implementation of this pattern is ongoing, parallel to the implementation of every feature and general code change.

 ### Consequences

 This pattern allows for a better structured and more organized code, while also making it easier to change the GUI used to display the game.



 ## Using state machines

 ### Problem in Context

 Implementing a state machine to control the state of the game, making it possible to transition from the menu to certain levels, and from those levels back to the menu.

 ### The Pattern

 In order to overcome this problem, we attempted to utilize the "State" design pattern, to allow our Game to change its behavior in run-time, depending on its current state.

 ### Implementation

 To implement this pattern, we created a class "CurrentLevel" which contains information about the player and the level currently being displayed. When the "play" function from one of the levels is called, the current level is sent to said level, where it will update its active game atribute whenever the game requires a level change.

 ### Consequences

 This pattern provides a smooth and explicit way to transition between our game's levels (states), dividing behavior for different states.



 ## Changing levels

 ### Problem in Context

 Finding a way to change into different levels, according to current state, without the use of several conditional statements.

 ### The Pattern

 As a way to deal with the problem at hand, we utilized the "Strategy" pattern, which allows us related classes (levels) that differ only in behavior.

 ### Implementation

 To implement this pattern, we created an interface "Game" with the methods "setPlayer", "draw", "play" and "update", which is implemented by our 5 level options (Menu, BattleTanks, LightCycles IOTower and MCPCone).

 ### Consequences

 This pattern lets us change our current game level depending on the state of our state machine, without the need of multiple conditional statements to specify which behavior is supposed to be in effect.


  

## Known Code Smells and Refactoring Suggestions

  

 ## Speculative Generality

 The interface "GameController" contains an "update" method that is never implemented in the classes that implement this interface, as it was created with future features in mind. The class "Wall" is also implemented but is never used currently. To refactor this code smell we could remove the code itself.

 ## Duplicate Code

 The way we read and interpret user inputs is placed in several different classes, even though it has the same function in all of them. A way to refactor this code smell would be to create a superclass for these different classes to deal with all inputs.

 ## Refused Bequest

 The class "Menu" implements the interface "GameController", and despite being fully implemented, it doesn't use the method "update" from "GameController". To refactor this code smell we could make a new Interface to be implemented by all the classes that currently implement "GameController", and create a separate interface with the methods unused by "Menu" and make the other classes implement it, alongside "GameController".


  

## Testing Results

  
 As of this intermediate, some unit tests have been implemented for general user inputs. Mutation testing and test coverage have not been done yet.
 Test Results:
 ![enter image description here](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/Tests.png "Test Results")


  

## Self-evaluation

  

 The work was divided evenly between both students, having both worked in coding and planning the game and its structure, as well as developing this report.
