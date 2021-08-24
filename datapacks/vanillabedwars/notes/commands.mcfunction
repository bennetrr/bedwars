# TNT, das nach 40 Ticks selbst explodiert
give @s mooshroom_spawn_egg{display:{Name:'{"text":"Instant TNT","color":"dark_red"}'},EntityTag:{id:"minecraft:tnt",Fuse:40}} 8

# Ein Fireball, der in die selbe Richtung fliegt, in die der Spieler guckt
scoreboard objectives add fireball used:carrot_on_a_stick
execute at @a[scores={fireball=1..}] run function fireball
execute as @a[scores={fireball=1..}] run scoreboard players set @s fireball 0

#region function fireball
execute positioned 0. 0 0. run summon fireball ^ ^ ^.1 {Tags:["fireball"]}
execute as @e[tag=fireball] run data modify entity @s power set from entity @s Pos
tp @e[tag=fireball] ~ ~ ~
tag @e remove fireball
#endregion