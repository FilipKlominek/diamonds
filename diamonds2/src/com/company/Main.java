package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("diamonds.csv"))) {

            ArrayList<Diamond> diamonds = new ArrayList<>();

            br.readLine();
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) break;

                String[] split = line.split(",");

                diamonds.add(new Diamond(
                        Integer.parseInt(split[0].substring(1, split[0].length() - 1)),
                        Double.parseDouble(split[1]),
                        split[2].substring(1, split[2].length() - 1),
                        split[3].substring(1, split[3].length() - 1),
                        split[4].substring(1, split[4].length() - 1),
                        Double.parseDouble(split[5]),
                        Double.parseDouble(split[6]),
                        Integer.parseInt(split[7]),
                        Double.parseDouble(split[8]),
                        Double.parseDouble(split[9]),
                        Double.parseDouble(split[10])
                ));
            }

            System.out.println(diamonds.stream()
                    .filter(diamond -> diamond.getCut().equals("Fair"))
                    .count()
            );

            System.out.println(diamonds.stream()
                    .filter(diamond -> diamond.getCut().equals("Premium"))
                    .mapToInt(Diamond::getPrice)
                    .average()
                    .orElse(Double.NaN)
            );
            var equalXY = diamonds.stream()
                    .filter(diamond -> diamond.getX() == diamond.getY())
                    .collect(Collectors.toList());
            for (Diamond diamond : equalXY) {
                System.out.print(diamond.getCut() + " " + diamond.getColor() + " (" + diamond.getPrice() + ") | ");
            }
            System.out.println();

            var possibleCuts = diamonds.stream()
                    .map(Diamond::getCut)
                    .distinct()
                    .toArray();
            for (Object possibleCut : possibleCuts) {
                System.out.print("\"" + possibleCut + "\", ");
            }
            System.out.println();

            var highestPriceFair = diamonds.stream()
                    .filter(diamond -> diamond.getCut().equals("Fair"))
                    .max(Comparator.comparing(Diamond::getPrice));
            var percentages = diamonds.stream()
                    .filter(diamond -> diamond.getCut().equals("Fair"))
                    .mapToDouble(diamond -> (double) diamond.getPrice() / highestPriceFair.get().getPrice() * 10000)
                    .sorted()
                    .toArray();
            for (int i = percentages.length - 1; i >= 0; i--) {
                System.out.println((double) Math.round(percentages[i] / 100) + "%");

            }

        } catch (IOException e) {
            System.out.println("Not found");
        }
    }
}
