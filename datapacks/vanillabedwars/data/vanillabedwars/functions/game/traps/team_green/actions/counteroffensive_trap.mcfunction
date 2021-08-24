scoreboard players set trapActive teamGreen 3
scoreboard players remove counteroffensiveTrap teamGreen 1
tellraw @a[team=teamGreen] {"text":"Eine gegenoffensive Falle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamGreen] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1