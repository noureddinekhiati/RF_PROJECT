public abstract class Classifier  {


    /***
     * permet d'initialiser les paramètres du classifieur.
     * Les classes filles étendront cette méthode en rajoutant les paramètres qui les concernent.
     * Le paramètre obligatoire d'un classifieur est le nombre de dimensions des données qu'il aura à traiter.
     * @param input_dimension nombre de dimensions des données qu'il aura à traiter
     */
    public Classifier(int input_dimension){

    }
    public abstract void train();
    public abstract void test();
    public abstract float evaluate();

}
