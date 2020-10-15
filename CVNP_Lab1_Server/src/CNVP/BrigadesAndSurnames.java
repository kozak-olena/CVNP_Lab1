package CNVP;
import java.util.Dictionary;

public class BrigadesRepository {

    public static Dictionary<Integer, String[]> Get() {

        Dictionary<Integer, String[]> brigadeAndSurnames = new Dictionary<Integer, String[]>;
        brigadeAndSurnames.put(1, new String[]{"МЕЛЬНИК", "БОЙКО", "КОВАЛЕНКО", "КОВАЛЬ"});
        brigadeAndSurnames.put(2, new String[]{"ПОЛІЩУК", "ТКАЧУК", "МОРОЗ", "ПЕТРЕНКО"});
        brigadeAndSurnames.put(3, new String[]{"РУДЕНКО", "СЕМЕНЮК", "КРАВЕЦЬ", "МАКАРЕНКО"});
        return brigadeAndSurnames;
    }
}
 
