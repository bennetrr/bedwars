scoreboard players set trapActive teamRed 4
scoreboard players remove detectionTrap teamRed 1
tellraw @a[team=teamRed] {"text":"Eine Aufdeckungfalle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamRed] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1