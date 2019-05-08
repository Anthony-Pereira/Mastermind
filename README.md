											
PRESENTATION OF THE APPLICATION


PUZZLE MODE || ENIGMA MODE:


	2 in 1 APPLICATION:

	Puzzle mode : 

		Find the secret combination using the +/- data given by Mastermind: 

			- search the good combination due to the answer you have. 

			- well placed (=) and misplaced (+ more than your number) (- less than your number).


		Mastermind mode : 

		Find the secret combination using the number well positioned and number present data given by Mastermind: 

			- search the good combination due to the answer you have. 

			- number well positioned: there are x number well positioned in your combination.

			- number present: there are x number present in your combination.


GAME MODE: 


	Three game mode available: CHALLENGER,DEFENDER,DUEL

		- Challenger: you must find the secret brainy combination.

		- Defender: Brainy must find your secret combination.

		- Duel: you and brainy are in competition, the first one who find the secret combination of Mr Computer win.



DIFFICULTY MODE:

This setting is available since the parameter file (config.PROPERTIES); 

you can modif the number case of secret combination possible and number of chance possible.

information: You can also change the insertion number that the user name can have.



DEVELOPPER MODE:

A developper mode is integrated.
For activate this, two possibilities : 
In config.properties file with systemMode variable with "true" or "false",
Otherwise directly in console to add a parameter "true" or "dev.


PREREQUISITES:

you need to install java 8 JDK


DEPLOYEMENT:

Step by step:
- Add the destination path of the mastermind.jar archive to the console.
- Add "true" or "dev" parameter to enable developer mode,
 
  exemple: java -jar Mastermind.jar true
	   java -jar Mastermind.jar dev

otherwise add "game" or "false" parameter to start in game mode.

  exemple: java -jar Mastermind.jar false
	   java -jar Mastermind.jar game

if there no parameter, the program start from the config.properties value system (systemMode).

You can also start the program directly from the IDE


BUILT WITH:

intellij idea - The ide used.
log4j libraries - To logging the errors.


VERSIONING:

I use git for versioning.


AUTHOR:

Anthony Pereira
