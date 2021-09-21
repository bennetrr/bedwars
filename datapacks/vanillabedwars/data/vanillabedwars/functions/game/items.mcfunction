# "Emergency" wooden sword
execute as @a[nbt=!{Inventory: [{id: "minecraft:wooden_sword"}]}, nbt=!{Inventory: [{id: "minecraft:stone_sword"}]}, nbt=!{Inventory: [{id: "minecraft:iron_sword"}]}, nbt=!{Inventory: [{id: "minecraft:diamond_sword"}]}] unless score @s eliminated matches 1.. run give @s wooden_sword{Unbreakable:1b} 1

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
execute as @e[scores={fireball=1..}] run clear @s carrot_on_a_stick 1
execute as @e[scores={fireball=1..}] run scoreboard players set @s fireball 0

# Pop up tower
execute at @e[type=item, nbt={Item: {id: "minecraft:trapped_chest"}, OnGround: 1b}] run clone 4 35 -117 8 42 -121 ~-2 ~ ~-2
execute as @e[type=item, nbt={Item: {id: "minecraft:trapped_chest"}, OnGround: 1b}] run kill @s