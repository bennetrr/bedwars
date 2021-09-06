#region Spawnpoints
spawnpoint @a[team=teamOrange] 672 45 -31
spawnpoint @a[team=teamGray] 722 45 -80
spawnpoint @a[team=teamGreen] 672 45 -129
spawnpoint @a[team=teamRed] 623 45 -80
#endregion

#region Death management
execute unless score trainMode data matches 1.. if score bedDestroyed teamOrange matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] eliminated 1
execute unless score trainMode data matches 1.. if score bedDestroyed teamGray matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] eliminated 1
execute unless score trainMode data matches 1.. if score bedDestroyed teamGreen matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] eliminated 1
execute unless score trainMode data matches 1.. if score bedDestroyed teamRed matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] eliminated 1

execute unless score bedDestroyed teamOrange matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] deaths 0
execute unless score bedDestroyed teamGray matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] deaths 0
execute unless score bedDestroyed teamGreen matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] deaths 0
execute unless score bedDestroyed teamRed matches 1.. run scoreboard players set @a[team=teamOrange, scores={deaths=1..}] deaths 0

execute if score trainMode data matches 1.. run scoreboard players set @a[scores={deaths=1..}] deaths 0

execute as @a[scores={eliminated=1}] run clear @s
execute as @a[scores={eliminated=1}] run gamemode spectator
execute as @a[scores={eliminated=1}] run tellraw @a ["",{"text":"Final Kill: ","color":"gold"},{"selector":"@s","color":"gold"}]
execute as @a[scores={eliminated=1}] run scoreboard players set @s eliminated 2
#endregion

#region Broken bed notification
execute if score bedDestroyed teamGray matches 1 run tellraw @a {"text": "Das Bett von Team Grau wurde zerstört!", "color": "gray"}
execute if score bedDestroyed teamGray matches 1.. run scoreboard players set bedDestroyed teamGray 2

execute if score bedDestroyed teamOrange matches 1 run tellraw @a {"text": "Das Bett von Team Orange wurde zerstört!", "color": "gold"}
execute if score bedDestroyed teamOrange matches 1.. run scoreboard players set bedDestroyed teamOrange 2

execute if score bedDestroyed teamGreen matches 1 run tellraw @a {"text": "Das Bett von Team Grün wurde zerstört!", "color": "green"}
execute if score bedDestroyed teamGreen matches 1.. run scoreboard players set bedDestroyed teamGreen 2

execute if score bedDestroyed teamRed matches 1 run tellraw @a {"text": "Das Bett von Team Rot wurde zerstört!", "color": "red"}
execute if score bedDestroyed teamRed matches 1.. run scoreboard players set bedDestroyed teamRed 2
#endregion

#region Winner determination
execute unless score trainMode data matches 1.. as @a[team=teamOrange] unless score @s eliminated matches 1.. unless entity @a[team=!teamOrange, scores={eliminated=0}] run tellraw @a {"text": "Team Orange hat gewonnen!", "color": "gold"}
execute unless score trainMode data matches 1.. as @a[team=teamOrange] unless score @s eliminated matches 1.. unless entity @a[team=!teamOrange, scores={eliminated=0}] run function vanillabedwars:cleanup

execute unless score trainMode data matches 1.. as @a[team=teamRed] unless score @s eliminated matches 1.. unless entity @a[team=!teamRed, scores={eliminated=0}] run tellraw @a {"text": "Team Rot hat gewonnen!", "color": "red"}
execute unless score trainMode data matches 1.. as @a[team=teamRed] unless score @s eliminated matches 1.. unless entity @a[team=!teamRed, scores={eliminated=0}] run function vanillabedwars:cleanup

execute unless score trainMode data matches 1.. as @a[team=teamGray] unless score @s eliminated matches 1.. unless entity @a[team=!teamGray, scores={eliminated=0}] run tellraw @a {"text": "Team Grau hat gewonnen!", "color": "gray"}
execute unless score trainMode data matches 1.. as @a[team=teamGray] unless score @s eliminated matches 1.. unless entity @a[team=!teamGray, scores={eliminated=0}] run function vanillabedwars:cleanup

execute unless score trainMode data matches 1.. as @a[team=teamGreen] unless score @s eliminated matches 1.. unless entity @a[team=!teamGreen, scores={eliminated=0}] run tellraw @a {"text": "Team Grün hat gewonnen!", "color": "green"}
execute unless score trainMode data matches 1.. as @a[team=teamGreen] unless score @s eliminated matches 1.. unless entity @a[team=!teamGreen, scores={eliminated=0}] run function vanillabedwars:cleanup
#endregion