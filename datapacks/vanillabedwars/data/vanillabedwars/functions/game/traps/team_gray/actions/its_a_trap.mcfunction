scoreboard players set trapActive teamGray 5
scoreboard players remove itsATrap teamGray 1
tellraw @a[team=teamGray] {"text":"Eine \"It's a trap!\"-Falle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamGray] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1