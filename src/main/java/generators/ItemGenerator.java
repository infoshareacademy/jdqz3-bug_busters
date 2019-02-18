package generators;

import dataModels.Bag;
import dataModels.BagType;

import java.util.Arrays;
import java.util.List;

public class ItemGenerator extends RandomGenerator {

    public static Bag generateBags() {

        Bag vintageCourier = new Bag(BagType.HANDBAGS, "Vintage courier bag", 25, "NK022", 60.00d);
        Bag chicVintage = new Bag(BagType.HANDBAGS, "Chic vintage DeVille", 14, "NK035", 78.00d);
        Bag vintageExotik = new Bag(BagType.HANDBAGS, "Vintage exotik carry bag", 12, "NK125", 62.00d);
        Bag multiUseHandBag = new Bag(BagType.HANDBAGS, "Multi use hand bag", 10, "NK028", 65.00d);
        Bag vintageBag = new Bag(BagType.HANDBAGS, "Vintage bag", 18, "NK089", 69.00d);
        Bag vintageChic = new Bag(BagType.HANDBAGS, "Vintage chic handbag", 15, "NK019", 68.00d);
        Bag vintageBeachBag = new Bag(BagType.BEACH_BAGS, "Vintage chic handbag", 15, "NK095", 60.00d);
        Bag retroStyleBag = new Bag(BagType.BEACH_BAGS, "Retro style bag", 20, "NK071", 48.00d);
        Bag vintageLaptopBag = new Bag(BagType.LAPTOP_BAGS, "Vintage laptop bag", 24, "NK124", 78.00d);
        Bag vintageBagWithLeatherBands = new Bag(BagType.BAGS, "Vintage bag with leather bands", 9, "NK033", 68.00d);

        List<Bag> handbagsList = Arrays.asList(vintageCourier, chicVintage, vintageExotik, multiUseHandBag, vintageBag, vintageChic, vintageBeachBag, retroStyleBag,
                vintageLaptopBag,vintageBagWithLeatherBands);

        Bag randomBag = handbagsList.get(generateRandomNumber(0, handbagsList.size()));
        return randomBag;
    }
}

