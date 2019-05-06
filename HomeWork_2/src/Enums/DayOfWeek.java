package Enums;

public enum DayOfWeek {

    MONDAY("40"), TUESDAY("32"), WEDNESDAY("24"), THURSDAY("16"), FRIDAY("8"), SATURDAY("Выходной день"), SUNDAY("Выходной день");

    private String workHoursLeft;

    DayOfWeek(String workHoursLeft){
        this.workHoursLeft = workHoursLeft;
    }

    public static String getWorkingHoursLeft(DayOfWeek dayOfWeek){
        return dayOfWeek.workHoursLeft;
    }
}
