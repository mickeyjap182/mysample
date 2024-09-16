package practice.basicfeature.ui.entities.scheduleset;

public sealed interface Period permits Rest, LongRest, Work{
    String getType();
}
