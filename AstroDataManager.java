import java.util.HashMap;
import java.util.Map;

public class AstroDataManager {
    private static final Map<String, AstrologyInfo> astroMap = new HashMap<>();
    private static final AstrologyInfo DEFAULT_INFO = new AstrologyInfo(
            "No details found!", 
            "No details found!", 
            "No details found!", 
            "No details found!", 
            "No details found!"
    );

    static {
        // Aries (Mesh)
        AstrologyInfo aries = new AstrologyInfo(
                "Aries (Mesh)",
                "Coral (Moonga)",
                "Tuesday (Mangalwar)",
                "Ashit Dhatu",
                "6-8 ct"
        );
        
        // Taurus (Vrish)
        AstrologyInfo taurus = new AstrologyInfo(
                "Taurus (vrish)",
                "Opel (Opel)",
                "Friday (Shukrawar)",
                "Asht Dhatu and silver",
                "8-11 ct"
        );
        
        // Gemini (Mithun)
        AstrologyInfo gemini = new AstrologyInfo(
                "Gemini (Mithun)",
                "Emerald (Panna)",
                "Wednesday (Bhudhwar)",
                "Asht Dhatu",
                "8-11 ct"
        );
        
        // Cancer (Kark)
        AstrologyInfo cancer = new AstrologyInfo(
                "Cancer (Kark)",
                "Pearl (Moti)",
                "Monday (Somwar)",
                "Asht Dhatu and Silver",
                "8-11 ct"
        );
        
        // Leo (Singh)
        AstrologyInfo leo = new AstrologyInfo(
                "Leo (Singh)",
                "Ruby (Manik)",
                "Sunday (Raviwar)",
                "Asht Dhatu",
                "8-11 ct"
        );
        
        // Virgo (Kanya)
        AstrologyInfo virgo = new AstrologyInfo(
                "Virgo (Kanya)",
                "Emerald (Panna)",
                "Wednesday (Bhudhwar)",
                "Asht Dhatu",
                "8-11 ct"
        );
        
        // Libra (Tula)
        AstrologyInfo libra = new AstrologyInfo(
                "Libra (Tula)",
                "Opel (Opel)",
                "Friday (Shukrawar)",
                "Asht Dhatu and Silver",
                "8-11 ct"
        );
        
        // Scorpio (Vrishchik)
        AstrologyInfo scorpio = new AstrologyInfo(
                "Scorpio (Vrishchik)",
                "Coral (Moonga)",
                "Tuesday (Mangalwar)",
                "Asht Dhatu",
                "6-8 ct"
        );
        
        // Sagittarius (Dhanu)
        AstrologyInfo sagittarius = new AstrologyInfo(
                "Sagittarius (Dhanu)",
                "Yellow Sapphire (Pukhraj)",
                "Thursday (Guruwar)",
                "Asht Dhatu and Gold",
                "6-8 ct"
        );
        
        // Capricorn (Makkar)
        AstrologyInfo capricorn = new AstrologyInfo(
                "Capricorn (Makkar)",
                "Blue Sapphire (Neelam)",
                "Saturday (Shaniwar)",
                "Panch Dhatu and Silver",
                "6-8 ct"
        );
        
        // Aquarius (Kumbh)
        AstrologyInfo aquarius = new AstrologyInfo(
                "Aquarius (Kumbh)",
                "Blue Sapphire (Neelam)",
                "Saturday (Shaniwar)",
                "Panch Dhatu and Silver",
                "6-8 ct"
        );
        
        // Pisces (Miet)
        AstrologyInfo pisces = new AstrologyInfo(
                "Pisces (Miet)",
                "Yellow Sapphire (Pukhraj)",
                "Thursday (Guruwar)",
                "Asht Dhatu and Gold",
                "6-8 ct"
        );

        // Aries prefixes
        String[] ariesPrefixes = {"chu", "che", "cho", "la", "le", "li", "lu", "lo", "a"};
        for (String prefix : ariesPrefixes) {
            astroMap.put(prefix, aries);
        }
        
        // Taurus prefixes
        String[] taurusPrefixes = {"e", "u", "ee", "o", "v", "va", "vi", "vu", "vay", "vo"};
        for (String prefix : taurusPrefixes) {
            astroMap.put(prefix, taurus);
        }
        
        // Gemini prefixes
        String[] geminiPrefixes = {"ka", "ki", "ku", "gh", "ang", "chh", "ke", "ko", "ha"};
        for (String prefix : geminiPrefixes) {
            astroMap.put(prefix, gemini);
        }
        
        // Cancer prefixes
        String[] cancerPrefixes = {"hi", "hu", "he", "ho", "da", "di", "du", "de", "do"};
        for (String prefix : cancerPrefixes) {
            astroMap.put(prefix, cancer);
        }
        
        // Leo prefixes
        String[] leoPrefixes = {"ma", "mi", "mu", "me", "mo", "ta", "ti", "tu", "te"};
        for (String prefix : leoPrefixes) {
            astroMap.put(prefix, leo);
        }
        
        // Virgo prefixes
        String[] virgoPrefixes = {"to", "pa", "pi", "pu", "sh", "na", "th", "pe", "po"};
        for (String prefix : virgoPrefixes) {
            astroMap.put(prefix, virgo);
        }
        
        // Libra prefixes
        String[] libraPrefixes = {"ra", "ri", "ru", "re", "ro", "ta", "ti", "tu", "te"};
        for (String prefix : libraPrefixes) {
            astroMap.put(prefix, libra);
        }
        
        // Scorpio prefixes
        String[] scorpioPrefixes = {"to", "na", "ni", "nu", "ne", "no", "ya", "yi", "u"};
        for (String prefix : scorpioPrefixes) {
            astroMap.put(prefix, scorpio);
        }
        
        // Sagittarius prefixes
        String[] sagittariusPrefixes = {"ye", "yo", "bha", "bhi", "bhu", "dha", "fa", "bhe", "bho"};
        for (String prefix : sagittariusPrefixes) {
            astroMap.put(prefix, sagittarius);
        }
        
        // Capricorn prefixes
        String[] capricornPrefixes = {"ja", "khi", "khu", "khe", "kho", "bhi", "kh", "ji", "ga"};
        for (String prefix : capricornPrefixes) {
            astroMap.put(prefix, capricorn);
        }
        
        // Aquarius prefixes
        String[] aquariusPrefixes = {"gu", "gay", "go", "sa", "si", "su", "s", "so", "da"};
        for (String prefix : aquariusPrefixes) {
            astroMap.put(prefix, aquarius);
        }
        
        // Pisces prefixes
        String[] piscesPrefixes = {"di", "du", "th", "jh", "yn", "de", "do", "cha", "chi"};
        for (String prefix : piscesPrefixes) {
            astroMap.put(prefix, pisces);
        }
    }

    public static AstrologyInfo getInfoByName(String name) {
        if (name == null || name.isEmpty()) {
            return DEFAULT_INFO;
        }
        
        name = name.toLowerCase();
        
        // Try with first 3 characters
        if (name.length() >= 3) {
            String prefix3 = name.substring(0, 3);
            if (astroMap.containsKey(prefix3)) {
                return astroMap.get(prefix3);
            }
        }
        
        // Try with first 2 characters
        if (name.length() >= 2) {
            String prefix2 = name.substring(0, 2);
            if (astroMap.containsKey(prefix2)) {
                return astroMap.get(prefix2);
            }
        }
        
        // Try with first character
        if (name.length() >= 1) {
            String prefix1 = name.substring(0, 1);
            if (astroMap.containsKey(prefix1)) {
                return astroMap.get(prefix1);
            }
        }
        
        return DEFAULT_INFO;
    }
}

