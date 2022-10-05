package join.operations.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import join.operations.model.DataRow;
import join.operations.model.JoinedDataRow;
import join.operations.service.JoinOperation;

public class InnerJoinOperationImpl<K extends Comparable<K>, V1, V2> implements
        JoinOperation<DataRow<K, V1>, DataRow<K, V2>, JoinedDataRow<K, V1, V2>> {

    @Override
    public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection,
                                                     Collection<DataRow<K, V2>> rightCollection) {
        Collection<JoinedDataRow<K, V1, V2>> innerJoinResult = new ArrayList<>();

        leftCollection.forEach(left -> rightCollection
                .stream()
                .filter(right -> left.getKey().equals(right.getKey()))
                .map(join -> new JoinedDataRow<>(left.getKey(), left.getValue(), join.getValue()))
                .forEach(innerJoinResult::add));

        return innerJoinResult;
    }
}
