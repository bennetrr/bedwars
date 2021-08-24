scoreboard players set trapActive teamOrange 5
scoreboard players remove itsATrap teamOrange 1
tellraw @a[team=teamOrange] {"text":"Eine \"It's a trap!\"-Falle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamOrange] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1