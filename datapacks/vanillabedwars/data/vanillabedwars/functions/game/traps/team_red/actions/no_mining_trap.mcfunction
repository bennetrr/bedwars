scoreboard players set trapActive teamRed 2
scoreboard players remove noMiningTrap teamRed 1
tellraw @a[team=teamRed] {"text":"Eine Abbaulämungsfalle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamRed] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1