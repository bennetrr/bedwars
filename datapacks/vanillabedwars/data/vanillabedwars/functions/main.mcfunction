# Execute the game mechanics if a game is running
execute if score gameActive data matches 1 run function vanillabedwars:game/main

# No game is running
execute if score gameActive data matches 0 run spawnpoint @a 999 43 7
execute if score gameActive data matches 0 run effect give @a saturation 2 255 true
execute if score gameActive data matches 0 run effect give @a regeneration 2 255 true
execute if score gameActive data matches 0 run effect give @a weakness 2 255 true


#region Start command
# Start task 1: Initialize scoreboards, teams, the game area and show the config ui
execute unless score gameActive data matches 1.. as @a[scores={start=1..}] run function vanillabedwars:init

# Set the maximal players per team
execute as @a[scores={uiAction=1}] unless score maxPlayerPerTeam data matches ..1 run scoreboard players remove maxPlayerPerTeam data 1
execute as @a[scores={uiAction=2}] unless score maxPlayerPerTeam data matches 6.. run scoreboard players add maxPlayerPerTeam data 1
execute as @a[scores={uiAction=1..2}] run function vanillabedwars:startui

# Toggle TrainMode
execute as @a[scores={uiAction=5}] if score trainMode data matches 0 run scoreboard players set trainMode data 1
execute as @a[scores={uiAction=6}] if score trainMode data matches 1.. run scoreboard players set trainMode data 0
execute as @a[scores={uiAction=5..6}] run function vanillabedwars:startui

# Start task 2: Assign players to teams, set villager trades, tp players to their islands, start the game
execute unless score gameActive data matches 1.. as @a[scores={uiAction=3}] run function vanillabedwars:init_late
#endregion

#region Stop command
# Stop task 1: Show security question
execute if score gameActive data matches 1.. as @a[scores={stop=1..}] run function vanillabedwars:stopui

# Stop task 2: Stop the game
execute if score gameActive data matches 1.. as @a[scores={uiAction=4}] run function vanillabedwars:cleanup
#endregion

# Score reset
execute as @a[scores={uiAction=1..}] run scoreboard players set @s uiAction 0
