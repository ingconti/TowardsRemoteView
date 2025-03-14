package it.polimi.towardsremoteview;
enum DinnerPhase implements Comparable<DinnerPhase> {
    UNKNOWN,
    ENTREE,
    MAIN_COURSE,
    SECOND_COURSE,
    DESSERT,
    THE_END_OF_LUNCH;

    DinnerPhase next() {

        switch (this) {
            case ENTREE:
                return MAIN_COURSE;

            case MAIN_COURSE:
                return SECOND_COURSE;

            case SECOND_COURSE:
                return DESSERT;

            case DESSERT:
                return THE_END_OF_LUNCH;

            case THE_END_OF_LUNCH:
                return THE_END_OF_LUNCH;
        }

        return UNKNOWN;
    }

    static DinnerPhase fromString(String s) {

        switch (s.toUpperCase().charAt(0)) {
            case 'E':
                return ENTREE;
            case 'M':
                return MAIN_COURSE;
            case 'S':
                return SECOND_COURSE;
            case 'D':
                return DESSERT;
            case 'T':
                return THE_END_OF_LUNCH;
            case 'U':
                return UNKNOWN;
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        switch (this) {
            case ENTREE:
                return "ENTREE";
            case MAIN_COURSE:
                return "MAIN COURSE";
            case SECOND_COURSE:
                return "SECOND COURSE";
            case DESSERT:
                return "DESSERT";
            case THE_END_OF_LUNCH:
                return "END OF YOUR LUNCH!";
        }
        return "UNKNOWN";
    }
}