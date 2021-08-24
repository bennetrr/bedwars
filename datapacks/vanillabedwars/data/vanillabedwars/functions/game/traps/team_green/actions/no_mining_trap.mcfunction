scoreboard players set trapActive teamGreen 2
scoreboard players remove noMiningTrap teamGreen 1
tellraw @a[team=teamGreen] {"text":"Eine Abbaulämungsfalle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamGreen] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1