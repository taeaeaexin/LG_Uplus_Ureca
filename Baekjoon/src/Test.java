import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "김건택", "김시헌", "김정민", "김지산", "문태신", "박기환", "박소연", "변지민", "서보인", "손민혁",
                "신수현", "신승우", "신혜원", "이도연", "이본규", "이재윤", "이종규", "이희용", "임민서", "장승범",
                "장현서", "정동현", "정성빈", "정유민", "정현경", "하령경", "한세영", "허승현", "홍석준"
        );

        Set<LocalDate> holidays = new HashSet<>();
        holidays.add(LocalDate.of(2025, 4, 18)); // 예: 휴강일

        LocalDate startDate = LocalDate.of(2025, 4, 17);
        int startIndex = names.indexOf("정유민");

        Map<LocalDate, String> schedule = new LinkedHashMap<>();

        int personIndex = startIndex;
        LocalDate currentDate = startDate;
        int totalCount = 60;

        while (schedule.size() < totalCount) {
            DayOfWeek day = currentDate.getDayOfWeek();
            boolean isWeekend = day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
            boolean isHoliday = holidays.contains(currentDate);

            if (!isWeekend && !isHoliday) {
                String name = names.get(personIndex % names.size());
                schedule.put(currentDate, name);
                personIndex++;
            }
            currentDate = currentDate.plusDays(1);
        }

        for (Map.Entry<LocalDate, String> entry : schedule.entrySet()) {
            LocalDate date = entry.getKey();
            String name = entry.getValue();
            String dayKorean = getKoreanDayOfWeek(date.getDayOfWeek());

            System.out.println(date + " (" + dayKorean + ") → " + name);
        }
    }

    private static String getKoreanDayOfWeek(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY: return "월요일";
            case TUESDAY: return "화요일";
            case WEDNESDAY: return "수요일";
            case THURSDAY: return "목요일";
            case FRIDAY: return "금요일";
            case SATURDAY: return "토요일";
            case SUNDAY: return "일요일";
            default: return "";
        }
    }
}