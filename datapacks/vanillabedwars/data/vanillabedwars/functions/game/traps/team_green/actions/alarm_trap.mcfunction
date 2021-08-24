scoreboard players set trapActive teamGreen 1
scoreboard players remove alarmTrap teamGreen 1
tellraw @a[team=teamGreen] {"text":"Eine Alarmfalle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamGreen] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1