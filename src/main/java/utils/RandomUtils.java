package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtils {

    private static final Faker FAKER = new Faker(new Locale("ru"));
    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private RandomUtils() {}

    public static String lastName()   { return FAKER.name().lastName(); }
    public static String firstName()  { return FAKER.name().firstName(); }
    public static String middleName() { return FAKER.name().nameWithMiddle().split(" ")[2]; }

    public static String phoneRu() {
        return "89" + ThreadLocalRandom.current().nextInt(100_000_000, 999_999_999);
    }

    public static String passportRu() {
        return String.format("%06d",
                ThreadLocalRandom.current().nextInt(100_000, 999_999));
    }

    public static String birthDate(int minAge, int maxAge) {
        int age = ThreadLocalRandom.current().nextInt(minAge, maxAge + 1);
        return LocalDate.now()
                .minusYears(age)
                .minusDays(ThreadLocalRandom.current().nextInt(0, 365))
                .format(DATE);
    }

    public static String futureDate(int minDays, int maxDays) {
        return LocalDate.now()
                .plusDays(ThreadLocalRandom.current().nextInt(minDays, maxDays + 1))
                .format(DATE);
    }

    public static String pastDate(int minDays, int maxDays) {
        return LocalDate.now()
                .minusDays(ThreadLocalRandom.current().nextInt(minDays, maxDays + 1))
                .format(DATE);
    }

    public static String city() { return FAKER.address().city(); }

}