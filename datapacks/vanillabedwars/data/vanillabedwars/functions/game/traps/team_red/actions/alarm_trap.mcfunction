scoreboard players set trapActive teamRed 1
scoreboard players remove alarmTrap teamRed 1
tellraw @a[team=teamRed] {"text":"Eine Alarmfalle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamRed] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1