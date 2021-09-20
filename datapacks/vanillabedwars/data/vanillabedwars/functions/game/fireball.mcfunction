execute positioned 0.0 0 0.0 run summon area_effect_cloud ^ ^ ^1 {Tags:["direction"]}
summon fireball ~ ~ ~ {Tags:["projectile"]}
data modify entity @e[type=fireball,tag=projectile,limit=1] power set from entity @e[type=area_effect_cloud,tag=direction,limit=1] Pos
tag @e[tag=projectile] remove projectile
kill @e[tag=direction]