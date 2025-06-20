package fonction;

public class MisyTsymisy {

    /**
     * Vérifie si les sélections correspondent aux critères
     * @return true si AU MOINS UN critère est satisfait, false sinon
     */
    public boolean fonction(String faritany, String region, String district, String bureau,
                            String selectfar, String selectreg, String selectdis, String selectbu) {

        // Si aucun filtre n'est sélectionné, tout correspond
        if (selectfar == null && selectreg == null && selectdis == null && selectbu == null) {
            return true;
        }

        // Vérifie chaque paire séparément
        boolean farMatch = (selectfar == null) || (faritany != null && faritany.equals(selectfar));
        boolean regMatch = (selectreg == null) || (region != null && region.equals(selectreg));
        boolean disMatch = (selectdis == null) || (district != null && district.equals(selectdis));
        boolean buMatch = (selectbu == null) || (bureau != null && bureau.equals(selectbu));

        // Retourne true seulement si TOUS les critères sélectionnés correspondent
        return farMatch && regMatch && disMatch && buMatch;
    }
}