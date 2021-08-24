scoreboard players set trapActive teamGray 1
scoreboard players remove alarmTrap teamGray 1
tellraw @a[team=teamGray] {"text":"Eine Alarmfalle wurde ausgelöst!","bold":true,"color":"dark_red"}

execute as @a[team=teamGray] at @s run playsound minecraft:event.raid.horn voice @s ~ ~ ~ 100 1 1