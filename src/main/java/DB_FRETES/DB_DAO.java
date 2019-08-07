package DB_FRETES;

public final class DB_DAO {

    private static DB_DAO dao;

    private DAO_Aparelhos Aparelhos;
    

    public DB_DAO() {
        setAparelhos(new DAO_Aparelhos());
        /*
        .
        .
        .
        */

    }

    public static DB_DAO getInstance() {
        if (getDao() == null) {
            setDao(new DB_DAO());
        }
        return getDao();
    }

    /**
     * @return the dao
     */
    public static DB_DAO getDao() {
        return dao;
    }

    /**
     * @param aDao the dao to set
     */
    public static void setDao(DB_DAO aDao) {
        dao = aDao;
    }

    /**
     * @return the Aparelhos
     */
    public DAO_Aparelhos getAparelhos() {
        return Aparelhos;
    }

    /**
     * @param Aparelhos the Aparelhos to set
     */
    public void setAparelhos(DAO_Aparelhos Aparelhos) {
        this.Aparelhos = Aparelhos;
    }

    

}
