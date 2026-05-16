# Cascades Cool Biomes

A datapack addon for Minecraft 1.21.1 that adds carefully selected WWEE biomes
on top of Cascades worldgen, while restoring vanilla biomes removed by Cascades.

## Requirements (load order)
1. [Cascades](https://modrinth.com/datapack/cascades) — terrain generation
2. [William Wythers Overhauled Overworld (WWOO)](https://modrinth.com/datapack/wwoo) — vanilla biome visuals
3. **This addon** — biome placement and new biomes

## Added biomes
ancient taiga, autumnal forest, bayou, cactus desert, cool stony peaks,
giant sequoia forest, glacial cliffs, highlands, jacaranda savanna,
lapacho plains, larch taiga, maple mountains, mediterranean island,
phantasmal forest, sakura forest, snowy tundra, volcanic crater

## Restored vanilla biomes
birch forest, old growth birch forest, windswept hills, windswept forest,
windswept gravelly hills, windswept savanna

## Biome placement logic
All wythers biomes carved from climatically matching vanilla donor slots
so they generate at correct ground level with Cascades terrain:

| Biome | Donor slot |
|---|---|
| autumnal forest | hybrid_beta:autumnal_forest (cold dry) |
| bayou | hybrid_beta:rainforest (hot humid) |
| maple mountains | meadow (temperate elevated) |
| glacial cliffs | frozen_peaks (cold peaks) |
| volcanic crater | badlands (hot rocky) |
| sakura forest | cherry_grove (pink/cherry zone) |
| phantasmal forest | dark_forest (dark eerie) |
| mediterranean island | beach (warm coastal) |

## Changelog
- **beta-0.4** *(May 15)* — Rebuilt overworld.json from scratch with correct climate logic, sunflower plains 92 entries
- **beta-0.3** *(May 13)* — Swapped andesite_crags for mediterranean_island, boosted sunflower plains + maple mountains
- **beta-0.2** *(May 11)* — Fixed biomes generating above terrain, restored all removed vanilla biomes
- **beta-0.1** *(May 10)* — First release (known bug: biomes at wrong y-level)

## Why addon format?
Ships only the overworld.json remap and WWEE biome/feature files.
No Cascades files included — fully compliant with Cascades license.

## Credits
- Terrain: [Cascades](https://modrinth.com/datapack/cascades)
- Biomes: [William Wythers Extended Ecosystem (WWEE)](https://modrinth.com/datapack/wwee)
- Vanilla overhaul: [WWOO](https://modrinth.com/datapack/wwoo)
