# "Emergency" wooden sword
execute as @a[nbt=!{Inventory: [{id: "minecraft:wooden_sword"}]}, nbt=!{Inventory: [{id: "minecraft:stone_sword"}]}, nbt=!{Inventory: [{id: "minecraft:iron_sword"}]}, nbt=!{Inventory: [{id: "minecraft:diamond_sword"}]}] unless score @s eliminated matches 1.. run give @s wooden_sword{HideFlags:8,Unbreakable:1b, CanDestroy:["minecraft:red_wool", "minecraft:green_wool", "minecraft:gray_wool", "minecraft:orange_wool", "cyan_wool", "red_bed", "gray_bed", "green_bed", "orange_bed"]} 1

# Bridge eggs
execute at @e[type=egg] facing entity @p eyes unless entity @a[distance=..2] run fill ^-1 ^ ^ ^-2 ^ ^ cyan_wool replace air
kill @e[type=chicken]
#endregion