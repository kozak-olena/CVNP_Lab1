package CNVP;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

  public class BrigadeRepository {

    public static HashMap<Integer, String[]> get() {

        HashMap<Integer, String[]> brigadeAndSurnames = new HashMap<Integer, String[]>();
        brigadeAndSurnames.put(1, new String[]{"МЕЛЬНИК", "БОЙКО", "КОВАЛЕНКО", "КОВАЛЬ"});
        brigadeAndSurnames.put(2, new String[]{"ПОЛІЩУК", "ТКАЧУК", "МОРОЗ", "ПЕТРЕНКО"});
        brigadeAndSurnames.put(3, new String[]{"РУДЕНКО", "СЕМЕНЮК", "КРАВЕЦЬ", "МАКАРЕНКО"});
        return brigadeAndSurnames;
    }



}
 
