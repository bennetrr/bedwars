# Cleanup and set gamerules
#function vanillabedwars:cleanup

gamerule maxCommandChainLength 999999
gamerule spawnRadius 0
gamerule doLimitedCrafting true

# Init data scoreboard and default values
scoreboard objectives add data dummy
#scoreboard players set gameActive data 0
execute unless score maxPlayerPerTeam data matches 1..6 run scoreboard players set maxPlayerPerTeam data 1
execute unless score trainMode data matches 0..1 run scoreboard players set trainMode data 0

tellraw @a "Reload complete!"