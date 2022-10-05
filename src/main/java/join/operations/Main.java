package join.operations;

import java.util.Collection;
import java.util.LinkedHashSet;
import join.operations.model.DataRow;
import join.operations.model.JoinedDataRow;
import join.operations.service.JoinOperation;
import join.operations.service.impl.InnerJoinOperationImpl;
import join.operations.service.impl.LeftJoinOperationImpl;
import join.operations.service.impl.RightJoinOperationImpl;

public class Main {
    public static void main(String[] args) {
        Collection<DataRow<Integer, String>> leftCollection = new LinkedHashSet<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "Germany"));
        leftCollection.add(new DataRow<>(2, "France"));

        Collection<DataRow<Integer, String>> rightCollection = new LinkedHashSet<>();
        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));

        JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>,
                JoinedDataRow<Integer, String, String>> joinOperation;

        System.out.println("------------------");
        System.out.println("InnerJoinOperation");

        joinOperation = new InnerJoinOperationImpl<>();
        System.out.println(joinOperation.join(leftCollection, rightCollection));

        System.out.println("------------------");
        System.out.println("LeftJoinOperation");
        joinOperation = new LeftJoinOperationImpl<>();
        System.out.println(joinOperation.join(leftCollection, rightCollection));

        System.out.println("------------------");
        System.out.println("RightJoinOperation");
        joinOperation = new RightJoinOperationImpl<>();
        System.out.println(joinOperation.join(leftCollection, rightCollection));
    }
}
