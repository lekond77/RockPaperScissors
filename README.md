# Rock Paper Scissor
## Game coded in Java by levels
## Level 1
This level determines the winner between two players. The program receives the players' choices as input and returns the winner. The winner is calculated as follows:

- RR => R

- RS => R

- SR => R

- RP => P

- PR => P

- PP => P

- PS => S

- SS => S

- SP => S

## Level 2
In this level, you need to determine the remaining string after two rounds of the game from a given player's string. For example, for the input string **"RSRRRSPPSRPSSPSPSPSRPPSRSPRPSSRP"**, the output should be: **RPRSRPSS**.

## Level 3
Level 3 involves creating a string from the number of Rocks, Papers, and Scissors such that Rock does not participate in the second round, giving Scissors a better chance to win. For example, for the input :

**"8R 5P 19S"** , an output could be:
**"RRPRRRPRRPRPPSSSSSSSSSSSSSSSSSSS"**
