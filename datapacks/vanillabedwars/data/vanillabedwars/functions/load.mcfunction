# Cleanup and set gamerules
function vanillabedwars:cleanup
gamerule maxCommandChainLength 999999
gamerule spawnRadius 0

# Init data scoreboard and default values
scoreboard objectives add data dummy
scoreboard players set gameActive data 0
execute unless score maxPlayerPerTeam data matches 1..6 run scoreboard players set maxPlayerPerTeam data 1