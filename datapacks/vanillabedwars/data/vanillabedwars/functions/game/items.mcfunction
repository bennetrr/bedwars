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

#region TNT
#region Block replacement
# Terracotta
execute as @e[type=tnt,nbt={Fuse:1s}] at @a run fill ~-1 ~-1 ~-1 ~1 ~1 ~1 air replace orange_terracotta
execute as @e[type=tnt,nbt={Fuse:1s}] at @a run fill ~-1 ~-1 ~-1 ~1 ~1 ~1 air replace cyan_terracotta
execute as @e[type=tnt,nbt={Fuse:1s}] at @a run fill ~-1 ~-1 ~-1 ~1 ~1 ~1 air replace red_terracotta
execute as @e[type=tnt,nbt={Fuse:1s}] at @a run fill ~-1 ~-1 ~-1 ~1 ~1 ~1 air replace green_terracotta

# Wool
execute as @e[type=tnt,nbt={Fuse:1s}] at @a run fill ~-1 ~-1 ~2 ~1 ~3 ~1 air replace #wool
#execute as @e[type=tnt,nbt={Fuse:1s}] at @a if blocks ~-1 ~-1 ~-1 ~1 ~1 ~1 air run fill ~-1 ~-1 ~-2 ~1 ~1 ~1 air replace #wool
#endregion

#endregion