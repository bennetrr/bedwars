#region Strength 
execute if score strengthUpgrade teamGray matches 1 run effect give @a[team=teamGray] strength 2 0 true
execute if score strengthUpgrade teamGray matches 2.. run effect give @a[team=teamGray] strength 2 1 true
#endregion

#region Regeneration
execute if score regenUpgrade teamGray matches 1.. run effect give @a[team=teamGray] regeneration 2 0 true
#endregion

#region Protection
#region Leather
#Prot 0
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:leather_helmet", tag: {Enchantments:[]}}]}] unless score @s armor matches 1.. unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.head with leather_helmet{Unbreakable:true, display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:leather_chestplate", tag: {Enchantments:[]}}]}] unless score @s armor matches 1.. unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.chest with leather_chestplate{Unbreakable:true, display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:leather_leggings", tag: {Enchantments:[]}}]}] unless score @s armor matches 1.. unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.legs with leather_leggings{Unbreakable:true, display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:leather_boots", tag: {Enchantments:[]}}]}] unless score @s armor matches 1.. unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.feet with leather_boots{Unbreakable:true, display:{color:5592405}}
#endregion

#Prot 1
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:leather_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 1 run item replace entity @s armor.head with leather_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:leather_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 1 run item replace entity @s armor.chest with leather_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:leather_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 1 run item replace entity @s armor.legs with leather_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:leather_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 1 run item replace entity @s armor.feet with leather_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}], display:{color:5592405}}
#endregion

#region Prot 2
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:leather_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 2 run item replace entity @s armor.head with leather_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:leather_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 2 run item replace entity @s armor.chest with leather_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:leather_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 2 run item replace entity @s armor.legs with leather_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:leather_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 2 run item replace entity @s armor.feet with leather_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}], display:{color:5592405}}
#endregion

#region Prot 3
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:leather_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 3 run item replace entity @s armor.head with leather_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:leather_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 3 run item replace entity @s armor.chest with leather_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:leather_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 3 run item replace entity @s armor.legs with leather_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:leather_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 3 run item replace entity @s armor.feet with leather_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}], display:{color:5592405}}
#endregion

#region Prot 4
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:leather_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 4.. run item replace entity @s armor.head with leather_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:leather_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 4.. run item replace entity @s armor.chest with leather_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:leather_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 4.. run item replace entity @s armor.legs with leather_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}], display:{color:5592405}}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:leather_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] unless score @s armor matches 1.. if score protUpgrade teamGray matches 4.. run item replace entity @s armor.feet with leather_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}], display:{color:5592405}}
#endregion
#endregion

#region Iron
#region Prot 0
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:iron_helmet", tag: {Enchantments:[]}}]}] if score @s armor matches 1 unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.head with iron_helmet{Unbreakable:true}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:iron_chestplate", tag: {Enchantments:[]}}]}] if score @s armor matches 1 unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.chest with iron_chestplate{Unbreakable:true}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:iron_leggings", tag: {Enchantments:[]}}]}] if score @s armor matches 1 unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.legs with iron_leggings{Unbreakable:true}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:iron_boots", tag: {Enchantments:[]}}]}] if score @s armor matches 1 unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.feet with iron_boots{Unbreakable:true}
#endregion

#region Prot 1
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:iron_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 1 run item replace entity @s armor.head with iron_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:iron_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 1 run item replace entity @s armor.chest with iron_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:iron_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 1 run item replace entity @s armor.legs with iron_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:iron_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 1 run item replace entity @s armor.feet with iron_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}]}
#endregion

#region Prot 2
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:iron_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 2 run item replace entity @s armor.head with iron_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:iron_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 2 run item replace entity @s armor.chest with iron_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:iron_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 2 run item replace entity @s armor.legs with iron_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:iron_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 2 run item replace entity @s armor.feet with iron_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}]}
#endregion

#region Prot 3
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:iron_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 3 run item replace entity @s armor.head with iron_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:iron_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 3 run item replace entity @s armor.chest with iron_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:iron_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 3 run item replace entity @s armor.legs with iron_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:iron_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 3 run item replace entity @s armor.feet with iron_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}]}
#endregion

#region Prot 4
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:iron_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 4.. run item replace entity @s armor.head with iron_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:iron_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 4.. run item replace entity @s armor.chest with iron_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:iron_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 4.. run item replace entity @s armor.legs with iron_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:iron_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] if score @s armor matches 1 if score protUpgrade teamGray matches 4.. run item replace entity @s armor.feet with iron_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}]}
#endregion
#endregion

#region Diamond
#region Prot 0
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:diamond_helmet", tag: {Enchantments:[]}}]}] if score @s armor matches 2.. unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.head with diamond_helmet{Unbreakable:true}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:diamond_chestplate", tag: {Enchantments:[]}}]}] if score @s armor matches 2.. unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.chest with diamond_chestplate{Unbreakable:true}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:diamond_leggings", tag: {Enchantments:[]}}]}] if score @s armor matches 2.. unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.legs with diamond_leggings{Unbreakable:true}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:diamond_boots", tag: {Enchantments:[]}}]}] if score @s armor matches 2.. unless score protUpgrade teamGray matches 1.. run item replace entity @s armor.feet with diamond_boots{Unbreakable:true}
#endregion

#region Prot 1
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:diamond_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 1 run item replace entity @s armor.head with diamond_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:diamond_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 1 run item replace entity @s armor.chest with diamond_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:diamond_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 1 run item replace entity @s armor.legs with diamond_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:diamond_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 1s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 1 run item replace entity @s armor.feet with diamond_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 1s}]}
#endregion

#region Prot 2
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:diamond_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 2 run item replace entity @s armor.head with diamond_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:diamond_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 2 run item replace entity @s armor.chest with diamond_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:diamond_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 2 run item replace entity @s armor.legs with diamond_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:diamond_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 2s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 2 run item replace entity @s armor.feet with diamond_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 2s}]}
#endregion

#region Prot 3
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:diamond_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 3 run item replace entity @s armor.head with diamond_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:diamond_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 3 run item replace entity @s armor.chest with diamond_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:diamond_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 3 run item replace entity @s armor.legs with diamond_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:diamond_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 3s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 3 run item replace entity @s armor.feet with diamond_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 3s}]}
#endregion

#region Prot 4
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 103b, id: "minecraft:diamond_helmet", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 4.. run item replace entity @s armor.head with diamond_helmet{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 102b, id: "minecraft:diamond_chestplate", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 4.. run item replace entity @s armor.chest with diamond_chestplate{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 101b, id: "minecraft:diamond_leggings", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 4.. run item replace entity @s armor.legs with diamond_leggings{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}]}
execute as @a[team=teamGray, nbt=!{Inventory: [{Slot: 100b, id: "minecraft:diamond_boots", tag: {Enchantments:[{id: "minecraft:protection", lvl: 4s}]}}]}] if score @s armor matches 2.. if score protUpgrade teamGray matches 4.. run item replace entity @s armor.feet with diamond_boots{Unbreakable:true, Enchantments:[{id: "minecraft:protection", lvl: 4s}]}
#endregion
#endregion
#endregion

#region Haste
execute if score hasteUpgrade teamGray matches 1 run effect give @a[team=teamGray] haste 2 0 true
execute if score hasteUpgrade teamGray matches 2.. run effect give @a[team=teamGray] haste 2 1 true
#endregion

#region Spawner upgrades
# TODO Zeiten anpassen
# Level 1
execute if score spawnerUpgrade teamGray matches 1 if score ironMax teamGray matches 31.. run scoreboard players set ironMax teamGray 30
execute if score spawnerUpgrade teamGray matches 1 if score goldMax teamGray matches 68.. run scoreboard players set goldMax teamGray 67

# Level 2 / 3
execute if score spawnerUpgrade teamGray matches 2..3 if score ironMax teamGray matches 21.. run scoreboard players set ironMax teamGray 20
execute if score spawnerUpgrade teamGray matches 2..3 if score goldMax teamGray matches 51.. run scoreboard players set goldMax teamGray 50

# Level 4
execute if score spawnerUpgrade teamGray matches 4.. if score ironMax teamGray matches 11.. run scoreboard players set ironMax teamGray 10
execute if score spawnerUpgrade teamGray matches 4.. if score goldMax teamGray matches 26.. run scoreboard players set goldMax teamGray 25
#endregion