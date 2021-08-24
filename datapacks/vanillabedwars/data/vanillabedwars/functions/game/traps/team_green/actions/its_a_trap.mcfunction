scoreboard players set trapActive teamGreen 5
scoreboard players remove itsATrap teamGreen 1
tellraw @a[team=teamGreen] {"text":"Eine \"It's a trap!\"-Falle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamGreen] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1