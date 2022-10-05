package join.operations.util;

import java.util.Collection;
import java.util.List;
import join.operations.model.DataRow;

public class DataTestUtil {

    public static Collection<DataRow<Integer, String>> getLeftCollectionCountries() {
        return List.of(
                new DataRow<>(0, "Ukraine"),
                new DataRow<>(1, "Germany"),
                new DataRow<>(2, "France"));
    }

    public static Collection<DataRow<Integer, String>> getRightCollectionCities() {
        return List.of(
                new DataRow<>(0, "Kyiv"),
                new DataRow<>(1, "Berlin"),
                new DataRow<>(3, "Budapest"));
    }
}
