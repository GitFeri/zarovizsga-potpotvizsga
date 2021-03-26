package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    List<Fish> fishes = new ArrayList<>();

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public List<String> getStatus() {
        List<String> status = new ArrayList<>();
        for (Fish fish : fishes) {
            status.add(fish.status());
        }
        return status;
    }

    public void removeFish() {
        fishes.removeIf(fish -> fish.getWeight() >= 11);
    }

    public void feed() {
        for (Fish fish : fishes) {
            fish.feed();
        }
    }
}
