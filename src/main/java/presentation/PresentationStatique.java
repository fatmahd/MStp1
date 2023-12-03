package presentation;
import metier.MetierIMPL;
import dao.DaoIMPL;

public class PresentationStatique {
    public static void main(String[] args) {
        DaoIMPL dao=new DaoIMPL();
        MetierIMPL metier=new MetierIMPL();
        metier.setDao(dao);
        System.out.println(metier.calcul());

    }
}
