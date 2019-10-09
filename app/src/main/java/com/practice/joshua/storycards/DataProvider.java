package com.practice.joshua.storycards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataProvider {

    public final static List<Story> storyList = new ArrayList<>();
    public final static Map<String, Story> storyMap = new HashMap<>();

    static {

        addStory("shirt101",
                "Cross-back training tank",
                "Our cross-back training tank is made from organic cotton with 10% Lycra for form and support, and a flattering feminine cut.",
                1);

        addStory("jacket101",
                "Bamboo thermal ski coat",
                "You’ll be the most environmentally conscious skier on the slopes - and the most stylish - wearing our fitted bamboo thermal ski coat, made from organic bamboo with recycled plastic down filling.",
                2);

        addStory("pants101",
                "Stretchy dance pants",
                "Whether dancing the samba, mastering a yoga pose, or scaling the climbing wall, our stretchy dance pants, made from 80% organic cotton and 20% Lycra, are the most versatile and comfortable workout pants you’ll ever have the pleasure of wearing.",
                3);

        addStory("shirt102",
                "Ultra-soft tank top",
                "This versatile tank can be worn in the gym, under a blazer, or for a day out in the sun. Made from our patented organic bamboo and cotton mix, our ultra-soft tank never stops feeling soft, even when you forget the fabric softener.",
                4);

        addStory("shirt103",
                "V-neck t-shirt",
                "Our pre-shrunk organic cotton t-shirt, with its slightly fitted waist and elegant V-neck is designed to flatter. You’ll want one in every color!",
                5);

        addStory("sweater101",
                "V-neck sweater",
                "This medium-weight sweater, made from organic knitted cotton and bamboo, is the perfect solution to a chilly night at the campground or a misty walk on the beach.",
                6);

        addStory("shirt104",
                "Polo shirt",
                "Our pre-shrunk organic cotton polo shirt is perfect for weekend activities, lounging around the house, and casual days at the office. With its triple-stitched sleeves and waistband, our polo has maximum durability.",
                7);

        addStory("shirt105",
                "Skater graphic T-shirt\n",
                "Hip at the skate park or around down, our pre-shrunk organic cotton graphic T-shirt has you covered.",
                8);

        addStory("jacket102",
                "Thermal fleece jacket",
                "Our thermal organic fleece jacket, is brushed on both sides for ultra softness and warmth. This medium-weight jacket is versatile all year around, and can be worn with layers for the winter season.",
                9);

        addStory("shirt106",
                "V-neck pullover",
                "This organic hemp jersey pullover is perfect in a pinch. Wear for casual days at the office, a game of hoops after work, or running your weekend errands.",
                10);

        addStory("shirt107",
                "V-neck T-shirt",
                "Our pre-shrunk organic cotton V-neck T-shirt is the ultimate in comfort and durability, with triple stitching at the collar, sleeves, and waist. So versatile you’ll want one in every color!",
                11);

        addStory("pants102",
                "Grunge skater jeans",
                "Our boy-cut jeans are for men and women who appreciate that skate park fashions aren’t just for skaters.  Made from the softest and most flexible organic cotton denim.",
                12);

        addStory("vest101",
                "Thermal vest",
                "Our thermal vest, made from organic bamboo with recycled plastic down filling, is a favorite of both men and women. You’ll help the environment, and have a wear-easy piece for many occasions.",
                13);
    }

    private static void addStory(String storyId, String name,
                                 String description, int page) {
        Story item = new Story(storyId, name, description, page);
        storyList.add(item);
        storyMap.put(storyId, item);
    }

    public static void deleteStory(Story removeStory) {
        storyList.remove(removeStory);
        storyMap.remove(removeStory);
    }

    public static List<String> getProductNames() {
        List<String> list = new ArrayList<>();
        for (Story story : storyList) {
            list.add(story.getName());
        }
        return list;
    }

    public static List<Story> getFilteredList(String searchString) {

        List<Story> filteredList = new ArrayList<>();
        for (Story story : storyList) {
            if (story.getStoryId().contains(searchString)) {
                filteredList.add(story);
            }
        }

        return filteredList;

    }
}
