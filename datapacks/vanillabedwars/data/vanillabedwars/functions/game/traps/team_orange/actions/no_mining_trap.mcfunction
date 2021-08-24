scoreboard players set trapActive teamOrange 2
scoreboard players remove noMiningTrap teamOrange 1
tellraw @a[team=teamOrange] {"text":"Eine Abbaulämungsfalle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamOrange] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1