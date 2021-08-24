scoreboard players set trapActive teamOrange 1
scoreboard players remove alarmTrap teamOrange 1
tellraw @a[team=teamOrange] {"text":"Eine Alarmfalle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamOrange] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1