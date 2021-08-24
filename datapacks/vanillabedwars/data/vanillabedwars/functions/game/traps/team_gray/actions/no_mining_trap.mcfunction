scoreboard players set trapActive teamGray 2
scoreboard players remove noMiningTrap teamGray 1
tellraw @a[team=teamGray] {"text":"Eine Abbaulämungsfalle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamGray] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1