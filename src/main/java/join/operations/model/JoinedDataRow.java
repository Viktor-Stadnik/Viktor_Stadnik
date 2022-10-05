package join.operations.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinedDataRow<K extends Comparable<K>, V1, V2> {
    private K key;
    private V1 firstValue;
    private V2 secondValue;
}
