
  

# LPOO_13 - Quadrivium

A Tron-inspired game, with 4 different sub games, each with various levels of difficulty. As in the original game, the difficulty only increases once all the sub games have been beat once. The sub games are the following:

- (based on I/O Tower) the player must enter a tower within a time limit, while avoiding or destroying enemies.

- (based on MCP Cone) the player must ascend into a cone, without touching the wall in front of it (this wall can be destroyed by shooting at it).

- (based on Battle Tanks) the player drives a tank in a maze, attempting to kill all enemies without dying.

- (based on Light Cycles) the player must guide a vehicle in an arena, while avoiding the trails left behind by the player and the enemy (or enemies).


This project was developed by [João Leite](https://github.com/Jopamoleite) (up201705312@fe.up.pt) and [Márcia Teixeira](https://github.com/marciat) (up201706065@fe.up.pt) for LPOO 2018/19.

  

## Implemented Features


 ### Level Manager

 This feature stores the current level/game and manages the transitions between these. This is done by the use of the class "CurrentLevel" stores the current game (or menu). When a game ends, the CurrentLevel's "game" is updated to the menu, and when the user selects a sector in the menu, the level is updated accordingly (each sector is associated with a specific game). 

 ### Menu

 The menu is shown when the game starts, after the user presses Enter in the controls screen. On the menu, the player is free to walk and is able to select the Game he wants to play by pressing the Enter key on top of one of the level's sectors. Each sector corresponds to a fixed level.
 Screenshot of the Menu:![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/Menu.png "Menu")

 ### Battle Tanks

 This mini-game (which can be played by selecting the red sector on the menu) is a shooter game. There are four enemies who move around and shoot red bullets, and the player must kill them by shooting at them, while trying to dodge their bullets. The player has three lives, and loses one everytime it collides with a red bullet or with an enemy. 500 points are won everytime the player kills an enemy, and when 2000 points are reached (when all enemies have been killed), an orange area shows up in the middle of the map; to win the game, the player must go to this area an press Enter.
 Screenshot of the Game:![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/BattleTanks.png "BattleTanks")

 ### Shooting

 This feature is used in the Battle Tanks mini-game. The player can shoot by pressing W/A/S/D. The pressed key determines the direction of the bullet: W - up, A - left, S - down, D - right.

 ### Light Cycles
 
 In this mini-game (which can be played by selecting the orange sector on the menu) there are two characters: the player and an enemy. Both leave trails behind as they move, and the goal is to survive for as long as possible without touching neither the trails or the map walls.
 Screenshot of the LightCycles:![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/LightCycles.png "LightCycles")
  
 ### Light Cycles Enemy Movement

 The enemy in the Light Cycles mini-game moves mostly randomly, however, it knows not to collide with the any of the walls, be it the maps walls, the player created walls, or its own walls: if the randomly generated direction makes it collide with a wall, it attempts to go in the next direction (Up-Right-Down-Left) instead. Therefore, the enemy can only die by becoming trapped by either it's own walls, or by the player.


## Planned Features

  ### I/O Tower

 Game logic for I/O Tower mini-game, not yet implemented for this delivery due to lack of time.
 Rough sketch of the intended GUI:![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/IOTower.png "IO Tower")
 

  ### MCP Cone

 Game logic for MCP Cone mini-game, not yet implemented for this delivery due to lack of time.
 Rough sketch of the intended GUI:![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/MCPCone.png "MCP Cone")

  

## Architecture
	

 ## General code structure - MVC

 ### Problem in Context
 Dividing each object into categories in order to facilitate changing the used GUI, as well as increasing code efficiency and organization.

 ### The Pattern

 In order to overcome this problem, we adopted the MVC architectural pattern, which divides the code into a Model, a View and a Controller, each with their own unique responsabilities. This pattern helped solve our problem as it allows for easy simultaneous developmemt (essential for this project), high cohesion and ease of modification (which was extremely important given that the program has two different UIs).

 The **Model** represents the object's data.

 The **View** displays the data from the model, and sends user actions to the controller.

 The **Controller** links model's data to the view, and interprets user actions.

 ### Implementation

 This pattern is the base of the whole project architecture, and its implementation is clear in most classes. The project is mainly divided in three packages: model, view and controller, that correspond to the three MVC parts.

 The following figure, based on the one from the LPOO lectures slides, shows an example of the implementation of the MVC for the player.
 ![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/MVC.png "MVC")


 ### Consequences

 This pattern allows for a better structured and more organized code, igh cohesion and ease of modification, having the latter been specially useful when changing from only Lanterna UI to both Lanterna and Swing UI (as most changes were only made on the View).
 

## Design


 ## Changing between levels/menu/screens - State Pattern

 ### Problem in Context

 Implementing a state machine to control the state of the game, making it possible to transition from the controls, win and lose screens to the menu, from the menu to certain levels, and from those levels back to the menu or to the win/lose screens.

 ### The Pattern

 In order to overcome this problem, we have applied the State design pattern, to allow our Game to change its behavior in run-time, depending on its current state. The states are represented by different subclasses, all of which implement the GameController interface.


 ### Implementation

 To implement this pattern, we created a class "LevelManager" which contains information about the player and the level currently being displayed. When the "play" function from one of the levels is called, the current level is sent to said level, where it will update its active game attribute whenever the game requires a level change. The transitions are handled by LevelManagerController.

 The following picture shows how the pattern was implemented. The "Context" is the LevelManagerController, the "State" is the GameController, and the "Concrete States" are all the other classes (that implement the GameController interface).

 ![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/State.png "State Pattern")

 These classes can be found in the following files:

 * [GameController](../src/main/java/com/quadrivium/g13/controller/GameController.java)

 * [BattleTanksController](../src/main/java/com/quadrivium/g13/controller/BattleTanksController.java)

 * [ControlsController](../src/main/java/com/quadrivium/g13/controller/ControlsController.java)

 * [IOTowerController](../src/main/java/com/quadrivium/g13/controller/IOTowerController.java)

 * [LightCyclesController](../src/main/java/com/quadrivium/g13/controller/LightCyclesController.java)

 * [LoseScreenController](../src/main/java/com/quadrivium/g13/controller/LoseScreenController.java)

 * [MCPConeController](../src/main/java/com/quadrivium/g13/controller/MCPConeController.java)

 * [MenuController](../src/main/java/com/quadrivium/g13/controller/MenuController.java)

 * [WinScreenController](../src/main/java/com/quadrivium/g13/controller/MenuController.java)


 ### Consequences

 This pattern provides a smooth and explicit way to transition between our game's levels (states), dividing behavior for different states.



 ## Different games with different behavior - Strategy Pattern

 ### Problem in Context

 Finding an organized and efficient way to have various mini-games and screens which are all related and have similar methods but have different behaviors.

 ### The Pattern

 As a way to deal with the problem at hand, we utilized the "Strategy" pattern. This pattern is appropriate for this problem, since it allows us to have related classes (levels) that differ in behavior.

 ### Implementation

 To implement this pattern, we created an interface "GameController" with the methods "setPlayer", "draw", "play" and "checkEnter", which is implemented by the controllers of all level options. The implementation of this pattern is very closely related to the implementation of the State pattern, as the various subclasses here represent the states of the State Pattern.

 The following picture shows how the pattern was implemented. The "Context" is the LevelManagerController, the "Strategy" is the GameController, and the "Concrete Strategies" are all the other classes (that implement the GameController interface).

 ![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/State.png "Strategy Pattern")

 These classes can be found in the following files:

 * [GameController](../src/main/java/com/quadrivium/g13/controller/GameController.java)

 * [BattleTanksController](../src/main/java/com/quadrivium/g13/controller/BattleTanksController.java)

 * [ControlsController](../src/main/java/com/quadrivium/g13/controller/ControlsController.java)

 * [IOTowerController](../src/main/java/com/quadrivium/g13/controller/IOTowerController.java)

 * [LightCyclesController](../src/main/java/com/quadrivium/g13/controller/LightCyclesController.java)

 * [LoseScreenController](../src/main/java/com/quadrivium/g13/controller/LoseScreenController.java)

 * [MCPConeController](../src/main/java/com/quadrivium/g13/controller/MCPConeController.java)

 * [MenuController](../src/main/java/com/quadrivium/g13/controller/MenuController.java)

 * [WinScreenController](../src/main/java/com/quadrivium/g13/controller/MenuController.java)

 ### Consequences

 This pattern lets us have multiple related levels with similar methods but different behavior, without the need of multiple conditional statements to specify which behavior is supposed to be in effect.

 
 ## Score changing according to game events - Observer Pattern

 ### Problem in Context

 Having a game score that is easily changed according to the events in the mini-game, and doing so with nicely structured and organized code.
 
 ### The Pattern

 To solve this problem we utilized the "Observer" pattern. This pattern is appropriate for this problem, since it allows us to have an object notify others everytime its state changes, and updating them accordingly.

 ### Implementation

 To implement this pattern, we created an abstract class "ScoreSubject" and a class "ScoreObserver". The implemented mini-games extend ScoreSubject, allowing them to have ScoreObservers that are notified everytime the games' score changes.

 The following picture shows how the pattern was implemented.

 ![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/Observer.png "Observer Pattern")

 These classes can be found in the following files:

 * [ScoreSubject](../src/main/java/com/quadrivium/g13/model/ScoreSubject.java)

 * [ScoreObserver](../src/main/java/com/quadrivium/g13/model/ScoreObserver.java)

 * [BattleTanksController](../src/main/java/com/quadrivium/g13/controller/BattleTanksController.java)

 * [LightCyclesController](../src/main/java/com/quadrivium/g13/controller/LightCyclesController.java)


 ### Consequences

 This pattern lets us have two entities, where the state of one depends on the other, in a clean and organized way. This also makes sure the score is always correctly updated according to the game events.


 ## Generating Enemies - Factory Method
 
 ### Problem in Context

 Finding an easy and clean-looking way to generate different enemies for the different mini-games.

 ### The Pattern

 To solve this problem the Factory Method was used. This was an adequate solution as it allows the code to deal only with the Enemy abstract class and work with the various enemies for the different games.

 ### Implementation

 To implement this pattern, we created an abstract class "Enemy" and  classes "BattleTanksEnemy" and "LightCyclesEnemy" that extend the "Enemy" class. The "GetEnemyFactory" class has a method that returns a new game-specific enemy, and receives the enemy position and the game initals as arguments.

 The following picture shows how the pattern was implemented.

 ![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/EnemyFactory.png "Enemy Factory")

 These classes can be found in the following files:

 * [Enemy](../src/main/java/com/quadrivium/g13/model/Enemy.java)

 * [BattleTanksEnemy](../src/main/java/com/quadrivium/g13/model/BattleTanksEnemy.java)

 * [LightCyclesEnemy](../src/main/java/com/quadrivium/g13/model/LightCyclesEnemy.java)

 * [GetEnemyFactory](../src/main/java/com/quadrivium/g13/model/GetEnemyFactory.java)



## Known Code Smells and Refactoring Suggestions

 These code smells have not been solved due to lack of time and prioritizing other aspects of the project (finishing essential parts and refactoring other more critical code smells).


 ## Duplicate Code

 There are multiple bits of duplicate code throughout the project. One example is in the updateBullets() function in [BattleTanksController](../src/main/java/com/quadrivium/g13/controller/BattleTanksController.java), where the switch statement that moves the bullet according to its direction is repeated twice: one for the player's bullets and another for the enemies'. This could be solved by using Extract Method.

 ## Long Method

 This code smell is also found in some methods of the project. The updateBullets() method referred above is one of them, and this could have also been fixed using Extract Method. The most critical Long Method is generateMap() in [BattleTanksController](../src/main/java/com/quadrivium/g13/controller/BattleTanksController.java). In this case, this could have been solved by, instead of generating the map walls that way, storing them in a file and reading from this file in this method.

 ## Primitive Obsession

 This code smell is found in the generateMap() functions both in [BattleTanksController](../src/main/java/com/quadrivium/g13/controller/BattleTanksController.java) and [LightCyclesController](../src/main/java/com/quadrivium/g13/controller/LightCyclesController.java). Like the Long Method smell, this could have been solved by storing the maps in a file and reading from that file.

 ## Refused Bequest

 Interfaces [BattleTanksView](../src/main/java/com/quadrivium/g13/view/BattleTanksView.java), [ControlsView](../src/main/java/com/quadrivium/g13/view/ControlsView.java), [LightCyclesView](../src/main/java/com/quadrivium/g13/view/LightCyclesView.java), [LoseScreenView](../src/main/java/com/quadrivium/g13/view/LoseScreenView.java), [MenuView](../src/main/java/com/quadrivium/g13/view/MenuView.java) and [WinScreenView](../src/main/java/com/quadrivium/g13/view/WinScreenView.java) all have the refreshScreen() method. However, this method is only implemented in the Lanterna views, and is useless in the Swing ones, although both implement the interfaces. This could be solved using Extract Superclass.



## Testing Results

 The application passes all the 63 unit tests implemented, as seen on the screenshot below.
 ![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/Tests.png "Test Results")
 
 Unit tests coverage:

 ![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/TestCoverageUnit.png "Unit Test Coverage")

 Mutation testing was also done. The coverage results are presented below, and the full report can be found [here](pitest/). The low coverage can be partially explained by the lack of tests that cover the View package and private methods.

 ![ ](https://github.com/FEUP-LPOO/projecto-lpoo-2019-lpoo_13/blob/master/docs/images/TestCoverageMutation.png "Mutation Test Coverage")

  

## Self-evaluation

 João Leite: 60%
 Márcia Teixeira: 40%
