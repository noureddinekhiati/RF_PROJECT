public abstract class Classifier  {


    /***
     * permet d'initialiser les paramètres du classifieur.
     * Les classes filles étendront cette méthode en rajoutant les paramètres qui les concernent.
     * Le paramètre obligatoire d'un classifieur est le nombre de dimensions des données qu'il aura à traiter.
     * @param inputDimension nombre de dimensions des données qu'il aura à traiter
     */
    public Classifier(int inputDimension){

    }

    /***
     *  Permet d'entrainer le modele sur l'ensemble donné
     *             desc_set: ndarray avec des descriptions
     *             label_set: ndarray avec les labels correspondants
     *             Hypothèse: desc_set et label_set ont le même nombre de lignes
      */
    public abstract void train(int descSet, int labelSet);

    /***
     * rend le score de prédiction sur x (valeur réelle)
     *             x: une description
     */
    public abstract float score(float x);

    /***
     * rend la prediction sur x
     *             x: une description
     * @param x
     */
    public abstract int predict(int x);

    /***
     *  Permet de calculer la qualité du système sur un dataset donné
     *
     * le nombre d'exemples du dataset qui sont bien classés par le classifieur par le nombre total d'exemples du dataset.
     * @param descSet
     * @param labelSet
     * @return
     */
    public float accuracy(int descSet, int labelSet){
        int n = descSet ;


    }

}
