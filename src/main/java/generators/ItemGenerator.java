package generators;

import dataModels.*;

import java.util.Arrays;
import java.util.List;

public class ItemGenerator extends RandomGenerator {

    private static Bag vintageCourier = new Bag(BagType.HANDBAGS, "Vintage courier bag", 25, "NK022", 60.00d);
    private static Bag chicVintage = new Bag(BagType.HANDBAGS, "Chic vintage DeVille", 14, "NK035", 78.00d);
    private static Bag vintageExotik = new Bag(BagType.HANDBAGS, "Vintage exotik carry bag", 12, "NK125", 62.00d);
    private static Bag multiUseHandBag = new Bag(BagType.HANDBAGS, "Multi use hand bag", 10, "NK028", 65.00d);
    private static Bag vintageBag = new Bag(BagType.HANDBAGS, "Vintage bag", 18, "NK089", 69.00d);
    private static Bag vintageChic = new Bag(BagType.HANDBAGS, "Vintage chic handbag", 15, "NK019", 68.00d);
    private static Bag vintageBeachBag = new Bag(BagType.BEACH_BAGS, "Vintage chic handbag", 15, "NK095", 60.00d);
    private static Bag retroStyleBag = new Bag(BagType.BEACH_BAGS, "Retro style bag", 20, "NK071", 48.00d);
    private static Bag vintageLaptopBag = new Bag(BagType.LAPTOP_BAGS, "Vintage laptop bag", 24, "NK124", 78.00d);
    private static Bag vintageBagWithLeatherBands = new Bag(BagType.BAGS, "Vintage bag with leather bands", 9, "NK033", 68.00d);

    public static Bag generateBags() {

        List<Bag> handbagsList = Arrays.asList(vintageCourier, chicVintage, vintageExotik, multiUseHandBag, vintageBag, vintageChic, vintageBeachBag, retroStyleBag,
                vintageLaptopBag, vintageBagWithLeatherBands);

        Bag randomBag = handbagsList.get(generateRandomNumber(0, handbagsList.size() - 1));
        return randomBag;
    }
}

