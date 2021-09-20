# "Emergency" wooden sword
execute as @a[nbt=!{Inventory: [{id: "minecraft:wooden_sword"}]}, nbt=!{Inventory: [{id: "minecraft:stone_sword"}]}, nbt=!{Inventory: [{id: "minecraft:iron_sword"}]}, nbt=!{Inventory: [{id: "minecraft:diamond_sword"}]}] unless score @s eliminated matches 1.. run give @s wooden_sword{HideFlags:8,Unbreakable:1b, CanDestroy:["minecraft:red_wool", "minecraft:green_wool", "minecraft:gray_wool", "minecraft:orange_wool", "minecraft:cyan_wool", "minecraft:red_bed", "minecraft:gray_bed", "minecraft:green_bed", "minecraft:orange_bed", "minecraft:cyan_stained_glass", "minecraft:cyan_terracotta", "minecraft:orange_terracotta", "minecraft:red_terracotta", "minecraft:green_terracotta", "minecraft:end_stone", "minecraft:ladder", "minecraft:oak_planks", "minecraft:crying_obsidian"]} 1

#region Armor
execute as @a[nbt={Inventory:[{id:"minecraft:iron_chestplate", tag:{needsReplacement:true}}]}] run scoreboard players set @s armor 1
execute as @a[nbt={Inventory:[{id:"minecraft:iron_chestplate", tag:{needsReplacement:true}}]}] run tellraw @s {"text": "Du hast eine komplette Eisenrüstung gekauft!", "color": "green"}
execute as @a[nbt={Inventory:[{id:"minecraft:iron_chestplate", tag:{needsReplacement:true}}]}] at @s run playsound minecraft:entity.experience_orb.pickup voice @s ~ ~ ~ 100 1 1
execute as @a[nbt={Inventory:[{id:"minecraft:iron_chestplate", tag:{needsReplacement:true}}]}] run clear @s iron_chestplate

execute as @a[nbt={Inventory:[{id:"minecraft:diamond_chestplate", tag:{needsReplacement:true}}]}] run scoreboard players set @s armor 2
execute as @a[nbt={Inventory:[{id:"minecraft:diamond_chestplate", tag:{needsReplacement:true}}]}] run tellraw @s {"text": "Du hast eine komplette Diamandrüstung gekauft!", "color": "green"}
execute as @a[nbt={Inventory:[{id:"minecraft:diamond_chestplate", tag:{needsReplacement:true}}]}] at @s run playsound minecraft:entity.experience_orb.pickup voice @s ~ ~ ~ 100 1 1
execute as @a[nbt={Inventory:[{id:"minecraft:diamond_chestplate", tag:{needsReplacement:true}}]}] run clear @s diamond_chestplate
#endregion

# Bridge eggs
execute at @e[type=egg] facing entity @p eyes unless entity @a[distance=..2] run fill ^-1 ^ ^ ^-2 ^ ^ cyan_wool replace air
kill @e[type=chicken]

# Fireballs
execute at @e[scores={fireball=1..}] run function vanillabedwars:game/fireball

# TNT and fireballs item deletion
execute at @e[type=tnt, nbt={Fuse: 1s}] run summon marker ~ ~ ~ {Tags:["deleter"]}
execute at @e[type=fireball] run summon marker ~ ~ ~ {Tags:["deleter"]}
tag @e[tag=deleter] add deleter2
tag @e[tag=deleter] remove deleter
execute at @e[tag=deleter2] run kill @e[type=item, distance=..10]
kill @e[tag=deleter2]