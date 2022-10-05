package join.operations.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import join.operations.model.DataRow;
import join.operations.model.JoinedDataRow;
import join.operations.service.JoinOperation;
import join.operations.util.DataTestUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.List;

class RightJoinOperationImplTest {
    private static JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>,
            JoinedDataRow<Integer, String, String>> joinOperation;
    private static Collection<JoinedDataRow<Integer, String, String>> expected;

    @BeforeAll
    static void beforeAll() {
        joinOperation = new RightJoinOperationImpl<>();
        expected = List.of(
                new JoinedDataRow<>(0, "Ukraine", "Kyiv"),
                new JoinedDataRow<>(1, "Germany", "Berlin"),
                new JoinedDataRow<>(3, null, "Budapest"));
    }

    @Test
    void operationRightJoin_Ok() {
        Collection<DataRow<Integer, String>> leftCollectionCountries =
                DataTestUtil.getLeftCollectionCountries();
        Collection<DataRow<Integer, String>> rightCollectionCities =
                DataTestUtil.getRightCollectionCities();

        Collection<JoinedDataRow<Integer, String, String>> actual =
                joinOperation.join(leftCollectionCountries, rightCollectionCities);

        assertEquals(expected, actual, "Collection must contain the same elements");
    }

    @Test
    void isNull_notOk() {
        assertThrows(NullPointerException.class,
                () -> joinOperation.join(null, null),
                "The collection can't be null");
    }
}
