package practice.basicfeature.ui.entities.scheduleset;

sealed interface Period permits Rest, LongRest, Work{
    String getType();
}
