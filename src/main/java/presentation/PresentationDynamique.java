package presentation;

import dao.DaoIMPL;
import metier.MetierIMPL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PresentationDynamique {
    public static void main(String[] args) {
        try {
            String filePath = "C:\\Users\\21629\\IdeaProjects\\MStp1\\src\\main\\java\\presentation\\config.txt ";

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                List<String> classNames = new ArrayList<>();
                String line;
                while ((line = br.readLine()) != null) {
                    classNames.add(line.trim());
                }

                DaoIMPL daoInstance = null;
                MetierIMPL metierInstance = null;

                for (String className : classNames) {
                    Class<?> clazz = Class.forName(className);
                    Object instance = clazz.getDeclaredConstructor().newInstance();

                    if (instance instanceof DaoIMPL) {
                        daoInstance = (DaoIMPL) instance;
                    } else if (instance instanceof MetierIMPL) {
                        metierInstance = (MetierIMPL) instance;
                    }
                }

                metierInstance.setDao(daoInstance);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
