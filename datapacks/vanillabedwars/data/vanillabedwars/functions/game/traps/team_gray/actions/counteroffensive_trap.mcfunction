scoreboard players set trapActive teamGray 3
scoreboard players remove counteroffensiveTrap teamGray 1
tellraw @a[team=teamGray] {"text":"Eine gegenoffensive Falle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamGray] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1