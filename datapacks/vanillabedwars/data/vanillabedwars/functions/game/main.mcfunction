# Saturation
effect give @a saturation 2 255 true

# Display how long the game runs
function vanillabedwars:game/timer

# Time when a piece of iron, gold, diamond or emerald should spawn
function vanillabedwars:game/spawntimer

#region Spawnpoints and death management
spawnpoint @a[team=teamOrange] 672 45 -31
spawnpoint @a[team=teamGray] 722 45 -80
spawnpoint @a[team=teamGreen] 672 45 -129
spawnpoint @a[team=teamRed] 623 45 -80

execute if score bedDestroyed teamOrange matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] eliminated 1
execute if score bedDestroyed teamGray matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] eliminated 1
execute if score bedDestroyed teamGreen matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] eliminated 1
execute if score bedDestroyed teamRed matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] eliminated 1

execute unless score bedDestroyed teamOrange matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] deaths 0
execute unless score bedDestroyed teamGray matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] deaths 0
execute unless score bedDestroyed teamGreen matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] deaths 0
execute unless score bedDestroyed teamRed matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] deaths 0

execute as @a[scores={eliminated=1}] run clear @s
execute as @a[scores={eliminated=1}] run gamemode spectator
execute as @a[scores={eliminated=1}] run tellraw @a ["",{"text":"Final Kill: ","color":"gold"},{"selector":"@s","color":"gold"}]
execute as @a[scores={eliminated=1}] run scoreboard players set @s eliminated 2
#endregion

#region tools
execute as @a[nbt=!{Inventory: [{id: "minecraft:wooden_sword"}]}, nbt=!{Inventory: [{id: "minecraft:stone_sword"}]}, nbt=!{Inventory: [{id: "minecraft:iron_sword"}]}, nbt=!{Inventory: [{id: "minecraft:diamond_sword"}]}] unless score @s eliminated matches 1.. run give @s wooden_sword{HideFlags:8,Unbreakable:1b, CanDestroy:["minecraft:red_wool", "minecraft:green_wool", "minecraft:gray_wool", "minecraft:orange_wool", "cyan_wool", "red_bed", "gray_bed", "green_bed", "orange_bed"]} 1
#endregion

#region Bed notification
execute if score bedDestroyed teamGray matches 1 run tellraw @a {"text": "Das Bett von Team Grau wurde zerstört!", "color": "gray"}
execute if score bedDestroyed teamGray matches 1.. run scoreboard players set bedDestroyed teamGray 2

execute if score bedDestroyed teamOrange matches 1 run tellraw @a {"text": "Das Bett von Team Orange wurde zerstört!", "color": "gold"}
execute if score bedDestroyed teamOrange matches 1.. run scoreboard players set bedDestroyed teamOrange 2

execute if score bedDestroyed teamGreen matches 1 run tellraw @a {"text": "Das Bett von Team Grün wurde zerstört!", "color": "green"}
execute if score bedDestroyed teamGreen matches 1.. run scoreboard players set bedDestroyed teamGreen 2

execute if score bedDestroyed teamRed matches 1 run tellraw @a {"text": "Das Bett von Team Rot wurde zerstört!", "color": "red"}
execute if score bedDestroyed teamRed matches 1.. run scoreboard players set bedDestroyed teamRed 2
#endregion

#region Determine the winner
execute as @a[team=teamOrange] unless score @s eliminated matches 1.. unless entity @a[team=!teamOrange, scores={eliminated=0}] run tellraw @a {"text": "Team Orange hat gewonnen!", "color": "gold"}
execute as @a[team=teamOrange] unless score @s eliminated matches 1.. unless entity @a[team=!teamOrange, scores={eliminated=0}] run function vanillabedwars:cleanup

execute as @a[team=teamRed] unless score @s eliminated matches 1.. unless entity @a[team=!teamRed, scores={eliminated=0}] run tellraw @a {"text": "Team Rot hat gewonnen!", "color": "red"}
execute as @a[team=teamRed] unless score @s eliminated matches 1.. unless entity @a[team=!teamRed, scores={eliminated=0}] run function vanillabedwars:cleanup

execute as @a[team=teamGray] unless score @s eliminated matches 1.. unless entity @a[team=!teamGray, scores={eliminated=0}] run tellraw @a {"text": "Team Grau hat gewonnen!", "color": "gray"}
execute as @a[team=teamGray] unless score @s eliminated matches 1.. unless entity @a[team=!teamGray, scores={eliminated=0}] run function vanillabedwars:cleanup

execute as @a[team=teamGreen] unless score @s eliminated matches 1.. unless entity @a[team=!teamGreen, scores={eliminated=0}] run tellraw @a {"text": "Team Grün hat gewonnen!", "color": "green"}
execute as @a[team=teamGreen] unless score @s eliminated matches 1.. unless entity @a[team=!teamGreen, scores={eliminated=0}] run function vanillabedwars:cleanup
#endregion

#region bridge eggs
execute at @e[type=egg] facing entity @p eyes unless entity @a[distance=..2] run fill ^-1 ^ ^ ^-2 ^ ^ cyan_wool
kill @e[type=chicken]
#endregion

#region Upgrades
function vanillabedwars:game/upgrades/team_orange
function vanillabedwars:game/upgrades/team_gray
function vanillabedwars:game/upgrades/team_green
function vanillabedwars:game/upgrades/team_red
#endregion

#region Traps
function vanillabedwars:game/traps/team_orange/detector
function vanillabedwars:game/traps/team_red/detector
function vanillabedwars:game/traps/team_gray/detector
function vanillabedwars:game/traps/team_green/detector
#endregion