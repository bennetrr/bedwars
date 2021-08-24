scoreboard players set trapActive teamRed 5
scoreboard players remove itsATrap teamRed 1
tellraw @a[team=teamRed] {"text":"Eine \"It's a trap!\"-Falle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamRed] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1