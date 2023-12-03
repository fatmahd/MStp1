package metier;

import dao.IDao;

public interface IMetier {
    public double calcul ();

    void setDao(IDao dao);
}
