package join.operations.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import join.operations.model.DataRow;
import join.operations.model.JoinedDataRow;
import join.operations.service.JoinOperation;

public class RightJoinOperationImpl<K extends Comparable<K>, V1, V2> implements
        JoinOperation<DataRow<K, V1>, DataRow<K, V2>, JoinedDataRow<K, V1, V2>> {

    @Override
    public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection,
                                                     Collection<DataRow<K, V2>> rightCollection) {

        Collection<JoinedDataRow<K, V1, V2>> rightJoinResult = new ArrayList<>();

        rightCollection.forEach(right -> rightCollection
                .stream()
                .filter(left -> right.getKey().equals(left.getKey()))
                .map(join -> new JoinedDataRow<>(right.getKey(), leftCollection
                        .stream()
                        .filter(left -> right.getKey().equals(left.getKey()))
                        .map(DataRow::getValue)
                        .findFirst()
                        .orElse(null), right.getValue()))
                .forEach(rightJoinResult::add));

        return rightJoinResult;
    }
}
